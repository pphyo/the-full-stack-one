package com.codoverse.asm.weaver;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class ConstructorWeaverMain {
	
	private ConstructorWeaverMain() {}
	
	public static void main(String[] args) throws Exception {
		if(args.length == 0) {
			System.err.println("Usage: ConstructorWeaverMain <ClassesDir> [<ClassesDir> ...]");
			System.exit(1);
		}
		
		int totalWoven = 0;
		
		for(String dirArg : args) {
			Path root = Paths.get(dirArg);
			if(!Files.isDirectory(root)) {
				System.out.println("[weaver] skipping non-existent classes dir: " + root);
				continue;
			}
			totalWoven += waveDirectory(root);
		}
		System.out.println("[weaver] done - wove constructors into " + totalWoven + " class(es).");
	}
	
	private static int waveDirectory(Path root) throws Exception {
		int woven = 0;
		try(Stream<Path> walk = Files.walk(root)) {
			for(Path classFile : walk.filter(p -> p.toString().endsWith(".class")).toList()) {
				if(weaveClassFile(classFile)) {
					woven ++;
				}
			}
		}
		return woven;
	}
	
	private static boolean weaveClassFile(Path classFile) throws Exception {
		byte[] original = Files.readAllBytes(classFile);
		
		ClassReader reader = new ClassReader(original);
		
		ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		
		ConstructorClassVisitor visitor = new ConstructorClassVisitor(writer);
		
		reader.accept(visitor, 0);
		
		byte[] woven = writer.toByteArray();
		if(!Arrays.equals(original, woven)) {
			Files.write(classFile, woven);
			System.out.println("[weaver] injected constructor -> " + classFile);
			return true;
		}
		return false;
	}

}
