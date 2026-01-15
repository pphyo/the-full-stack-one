package tech.codoverse.annotation;

import java.lang.reflect.Field;

public class AnnotationResult {
	
	public static void generate(Object obj) throws IllegalArgumentException, IllegalAccessException {
		
		Class<?> clzz = obj.getClass();
		
		Field[] fields = clzz.getDeclaredFields();
		
		for(Field field : fields) {
			
			if(field.isAnnotationPresent(Info.class)) {
				
				field.setAccessible(true);
				
				Info anno = field.getAnnotation(Info.class);
				
				field.set(obj, anno.value().isBlank() ? "No Data" : anno.value());
				
			}
			
		}
		
	}

}
