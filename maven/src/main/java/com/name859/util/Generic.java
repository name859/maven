package com.name859.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Generic {

	@SuppressWarnings("rawtypes")
	public static Class getClassOfGenericType(Class cls, int index) {
		ParameterizedType genericSuperclass = (ParameterizedType)cls.getGenericSuperclass();
		Type wantedClassType = genericSuperclass.getActualTypeArguments()[index];
		if (wantedClassType instanceof ParameterizedType) {
			return (Class)((ParameterizedType)wantedClassType).getRawType();
		} else {
			return (Class)wantedClassType;
		}
	}
	
}
