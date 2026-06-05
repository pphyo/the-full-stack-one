package com.codoverse.di;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

@Target({ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface MessageQualifier {
	
	MessageEnum value() default MessageEnum.EMAIL;
	
	public enum MessageEnum {
		EMAIL, SMS
	}

}
