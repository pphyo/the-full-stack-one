package com.codoverse.asm.weaver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import com.codoverse.asm.annotations.CustomArgsConstructor;
import com.codoverse.asm.annotations.OfConstructor;

public class ConstructorClassVisitor extends ClassVisitor {
	
	private static final String CUSTOM_ARGS_CONSTRUCTOR_DESC = Type.getDescriptor(CustomArgsConstructor.class);
	private static final String OF_CONSTRUCTOR_DESC = Type.getDescriptor(OfConstructor.class);
	
	private final List<FieldInfo> taggedFields = new ArrayList<>();
	private final Set<String> existingConstructorDescriptors = new HashSet<>();
	
	private String className;
	private String superName;
	private boolean generateConstructor;
	private int fieldCounter;

	public ConstructorClassVisitor(ClassVisitor classVisitor) {
		super(Opcodes.ASM9, classVisitor);
	}
	
	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		this.className = name;
		this.superName = superName;
		super.visit(version, access, name, signature, superName, interfaces);
	}
	
	@Override
	public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
		if(CUSTOM_ARGS_CONSTRUCTOR_DESC.equals(descriptor))
			generateConstructor = true;
		return super.visitAnnotation(descriptor, visible);
	}
	
	@Override
	public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
		FieldVisitor delegate = super.visitField(access, name, descriptor, signature, value);
		
		if((access & Opcodes.ACC_STATIC) != 0) {
			return delegate;
		}
		
		int myIndex = fieldCounter ++;
		
		return new FieldVisitor(Opcodes.ASM9, delegate) {
			private int explicitOrder = Integer.MAX_VALUE;
			private boolean tagged = false;

			@Override
			public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
				AnnotationVisitor delegateAv = super.visitAnnotation(descriptor, visible);
				
				if(!OF_CONSTRUCTOR_DESC.equals(descriptor)) {
					return delegateAv;
				}
				
				tagged = true;
				
				return new AnnotationVisitor(Opcodes.ASM9, delegateAv) {
					@Override
					public void visit(String name, Object value) {
						if("order".equals(name) && value instanceof Integer intVal) {
							explicitOrder = intVal;
						}
						super.visit(name, value);
					}
				};
			}
			
			@Override
			public void visitEnd() {
				super.visitEnd();
				if(tagged) {
					taggedFields.add(new FieldInfo(name, descriptor, myIndex, explicitOrder));
				}
			}
		};
	}
	
	@Override
	public MethodVisitor visitMethod(int access, String name, String descriptor, String signature,
			String[] exceptions) {
		if("<init>".equals(name)) {
			existingConstructorDescriptors.add(descriptor);
		}
		return super.visitMethod(access, name, descriptor, signature, exceptions);
	}
	
	@Override
	public void visitEnd() {
		if(generateConstructor && !taggedFields.isEmpty()) {
			emitConstructor();
		}
		super.visitEnd();
	}
	
	private void emitConstructor() {
	    List<FieldInfo> ordered = new ArrayList<>(taggedFields);
	    ordered.sort(Comparator.comparingInt(FieldInfo::explicitOrder)
	                .thenComparingInt(FieldInfo::declarationIndex));

	    String methodDescriptor = buildDescriptor(ordered);

	    if (existingConstructorDescriptors.contains(methodDescriptor)) {
	        return;
	    }

	    MethodVisitor mv = super.visitMethod(Opcodes.ACC_PUBLIC, "<init>", methodDescriptor, null, null);
	    mv.visitCode();

	    mv.visitVarInsn(Opcodes.ALOAD, 0);
	    mv.visitMethodInsn(Opcodes.INVOKESPECIAL, superName, "<init>", "()V", false);

	    int localSlot = 1;
	    for (var field : ordered) {
	        Type fieldType = Type.getType(field.descriptor());
	        mv.visitVarInsn(Opcodes.ALOAD, 0);
	        mv.visitVarInsn(loadOpcodeFor(fieldType), localSlot);
	        mv.visitFieldInsn(Opcodes.PUTFIELD, className, field.name(), field.descriptor());

	        localSlot += fieldType.getSize();
	    }

	    mv.visitInsn(Opcodes.RETURN);
	    mv.visitMaxs(0, 0);
	    mv.visitEnd();
	}
	
	private String buildDescriptor(List<FieldInfo> ordered) {
		var sb = new StringBuffer("(");
		for(var field : ordered) {
			sb.append(field.descriptor());
		}
		return sb.append(")V").toString();
	}
	
	private static int loadOpcodeFor(Type type) {
		return switch(type.getSort()) {
		case Type.BOOLEAN, Type.BYTE, Type.CHAR, Type.SHORT, Type.INT -> Opcodes.ILOAD;
		case Type.LONG -> Opcodes.LLOAD;
		case Type.FLOAT -> Opcodes.FLOAD;
		case Type.DOUBLE -> Opcodes.DLOAD;
		case Type.ARRAY, Type.OBJECT -> Opcodes.ALOAD;
		default -> throw new IllegalStateException("Unsupported field type for constructor injection: " + type);
		};
	}

}
