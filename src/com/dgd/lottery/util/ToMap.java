package com.dgd.lottery.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.dgd.lottery.user.dao.User;

public class ToMap {

	public Map<String, Object> tomap(Object bean) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Class type = bean.getClass();
		System.out.println("name----" + type.getName());
		System.out.println("simplename----" + type.getSimpleName());
		System.out.println("typename----" + type.getTypeName());
		System.out.println("CanonicalName----" + type.getCanonicalName());
		System.out.println("Modifiers----" + type.getModifiers());
		System.out.println("getMethods----" + type.getMethods());
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(type);
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(beanInfo);
		/*PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			System.out.println("------------" + propertyDescriptor);
			Method methodSetUserName = propertyDescriptor.getWriteMethod();
			System.out.println(methodSetUserName);
			methodSetUserName.invoke(bean, "wong"); 
			// 内自省
			
			
		}*/
		// 内自省的用法
		// PropertyDescriptor pro = new PropertyDescriptor();
		
		//System.out.println(propertyDescriptors);
 		return null;
	}
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ToMap tm = new ToMap();
		User u = new User();
		tm.tomap(u);
	}
	// aaaaa
}
