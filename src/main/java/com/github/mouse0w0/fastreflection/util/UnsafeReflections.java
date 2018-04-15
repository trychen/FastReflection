package com.github.mouse0w0.fastreflection.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public interface UnsafeReflections {

	public static Field accessible(Field field) {
		field.setAccessible(true);
		return field;
	}

	public static Field unfinal(Field field) throws ReflectiveOperationException {
		Field modifiers = Field.class.getDeclaredField("modifiers");
		modifiers.setAccessible(true);
		modifiers.setInt(field, field.getModifiers() &~ Modifier.FINAL);
		return field;
	}
}