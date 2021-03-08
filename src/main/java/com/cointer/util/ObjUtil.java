package com.cointer.util;



import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;






public class ObjUtil {


	   public static  final String  Str="str";
	     
	   /** 
	    * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list 
	 * @throws Exception 
	    * */  
	   public static List<Map<String,Object>> getFieldsInfo(Object o) throws Exception{  
	    Field[] fields=o.getClass().getDeclaredFields();   
	        List <Map<String,Object>>list = new ArrayList<Map<String,Object>>();  
	        Map<String,Object> infoMap=null;  
	    for(int i=0;i<fields.length;i++){  
	    	Object value=getFieldValue(fields[i], o);
	    	if(value!=null) {
	    		infoMap = new HashMap<String,Object>();  
	 	        infoMap.put("type", fields[i].getType().toString());  
	 	        infoMap.put("name", fields[i].getName());  
	 	        infoMap.put("value",value);  
	 	        list.add(infoMap);  
	    	}
	    	
	       
	    }  
	    return list;  
	   }  
	   /** 
	    * 属性名(name)，属性值(value)的map
	 * @throws Exception 
	    * */ 
	   
//	   [private long bean.dbBean.acc.Id,
//	   protected java.lang.String bean.dbBean.acc.acc,
//	   protected java.lang.String bean.dbBean.acc.nick,
//	   protected int bean.dbBean.acc.sex,
//	   protected java.lang.String bean.dbBean.acc.portrait,
//	   protected int bean.dbBean.acc.inviter,
//	   protected int bean.dbBean.acc.type,
//	   protected long bean.dbBean.acc.reg_time
//	   ]
	   
	   public static Map getFileds(Object o,String vType,boolean containsNull) throws Exception{  
		 
		   List<Field> fields = new ArrayList<>() ;
		   Class tempClass = o.getClass();
		   while (tempClass != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
			   fields.addAll(Arrays.asList(tempClass .getDeclaredFields()));
			      tempClass = tempClass.getSuperclass(); //得到父类,然后赋给自己
			}
		   Map<String,Object>map = new HashMap<String,Object>();   
		   for(int i=0;i<fields.size();i++){ 
			   Object currObj=getFieldValue(fields.get(i), o);
			   if(vType.equals(Str)&&currObj!=null){
				   currObj=currObj.toString();
			   }
//			   Object currObj= vType.equals(Str)?getFieldValue(fields[i], o).toString():getFieldValue(fields[i], o);
			   if(containsNull||currObj!=null){
				   map.put(fields.get(i).getName(),currObj);  
			   }
			    
		   }  
		   return map;  
	   } 
	   
	   /** 
	    * 获取对象的所有属性值，返回一个对象数组 
	 * @throws Exception 
	    * */  
	   public static Object[] getFieldValues(Object o) throws Exception{  
	    Field[] fields=o.getClass().getDeclaredFields();;  
	    Object[] value=new Object[fields.length];  
	    for(int i=0;i<fields.length;i++){  
	        value[i]=getFieldValue(fields[i], o);  
	    }  
	    return value;  
	   }  
	   /** 
	    * 获取属性名数组 
	    * */  
	   private static String[] getFieldNames(Object o){  
	    Field[] fields=o.getClass().getDeclaredFields();  
	        String[] fieldNames=new String[fields.length];  
	    for(int i=0;i<fields.length;i++){  
//	        System.out.println(fields[i].getType());  
	        fieldNames[i]=fields[i].getName();  
	    }  
	    return fieldNames;  
	   }  
	 
	   
	   
	   /** 
	    * 填充对象
	    * */ 
	   
	   public static final void fillObj(Object obj, Map<String,Object> map) throws Exception {
		   Iterator<Map.Entry<String, Object>>  iter=map.entrySet().iterator();
		   while(iter.hasNext()){
			   Map.Entry entry=iter.next();
			   String fieldName=(String) entry.getKey();
			   Object fieldValue=entry.getValue();
			   setFieldValue(obj, fieldName, fieldValue);
		   }
	   }
	   
	   
	   
	   /** 
	    * 设置属性值
	    * */  
		
		private static final void setFieldValue(Object obj, String fieldName, Object fieldValue) throws Exception {
			Class<?> clazz = obj.getClass();
			Field field = clazz.getDeclaredField(fieldName);
			int modifiers = field.getModifiers();
			if ((Modifier.isTransient(modifiers)) || (Modifier.isStatic(modifiers))) {
				return;
			}
			if (Modifier.isPublic(modifiers))
				field.set(obj, fieldValue);
			else
				writeValueFromSetter(field, obj, fieldValue);
		}
		private static void writeValueFromSetter(Field field, Object obj, Object fieldValue) throws Exception {
			String setterName = "set" + StringUtil.capitalize(field.getName());
			try {
				Method setterMethod = obj.getClass().getMethod(setterName, new Class[] { field.getType() });
				setterMethod.invoke(obj, new Object[] { fieldValue });
			} catch (NoSuchMethodException e) {
			}
		}
		


		/** 
		 * 根据属性名获取属性值 
		 * */  
		private static final Object getFieldValue(Field field,Object obj) throws Exception {
			int modifiers = field.getModifiers();
			if ((Modifier.isTransient(modifiers)) || (Modifier.isStatic(modifiers))) {
				return null;
			}
			Object fieldValue = null;


			if (Modifier.isPublic(modifiers)) {
				fieldValue = field.get(obj);
			} else {
				fieldValue = readValueFromGetter(field.getName(), field.getType().getSimpleName(), obj);
			}
			return fieldValue;
		}
		private static Object readValueFromGetter(String fieldName, String type, Object obj) throws Exception {
			Object value = null;
			boolean isBool = type.equalsIgnoreCase("boolean");
			String getterName = isBool?"is":"get" + StringUtil.capitalize(fieldName);
			Method getterMethod = obj.getClass().getMethod(getterName, new Class[0]);
			value = getterMethod.invoke(obj, new Object[0]);


			return value;
		}
	   
	
		
		
		

	
}
    