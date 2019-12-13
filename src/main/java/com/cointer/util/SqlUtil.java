package com.cointer.util;




import java.sql.SQLException;
import java.util.List;
import java.util.Map;







/**
 * Db 数据库工具
 * @author daixiwei
 *
 */
public class SqlUtil {
	
	
	private static final String STR_NULL = "";
	private static final char   CHAR_COMMA = ',';
	private static final char   CHAR_QUOTES = '\'';

	

	
	public String genInsertSql(String tabName,List<Map<String,Object>> dataList) throws SQLException{
		if(StringUtil.isEmpty(tabName)){
			throw new SQLException("table is null!");
		}
		if(dataList == null){
			throw new SQLException("data is null!");
		}
		StringBuilder valuesql = new StringBuilder();
		StringBuilder keysql = new StringBuilder();
		int count =0;
		for (int i=0;i<dataList.size();i++) {
			if(count>0){
				keysql.append(CHAR_COMMA);
				valuesql.append(CHAR_COMMA);
			}
			count++;
			Map<String,Object>  data=  dataList.get(i);
			String key=(String)data.get("name");
			String type=(String)data.get("type");
			keysql.append(key);
			switch(type){
				case "short":
				case "int":
				case "double":
				case "float":
				case "byte":
				case "boolean":
				case "long":
				case "class java.lang.Integer":
				case "class java.lang.Long":
				case "class java.lang.Double":	
					valuesql.append(data.get("value"));
					break;
				case "class java.lang.String":
				case "class java.math.BigDecimal":
					valuesql.append(CHAR_QUOTES);
					valuesql.append(data.get("value"));
					valuesql.append(CHAR_QUOTES);
					break;	
				default:
					break;
			} 
		}

		String sql = String.format("INSERT INTO %s (%s) VALUES(%s)", tabName,keysql,valuesql);
		return sql;
	}
	public static String genInsertMapper(String tabName,List<Map<String,Object>> dataList) throws SQLException{
		if(StringUtil.isEmpty(tabName)){
			throw new SQLException("table is null!");
		}
		if(dataList == null){
			throw new SQLException("data is null!");
		}
		StringBuilder valuesql = new StringBuilder();
		StringBuilder keysql = new StringBuilder();
		int count =0;
		for (int i=0;i<dataList.size();i++) {
			if(count>0){
				keysql.append(CHAR_COMMA);
				valuesql.append(CHAR_COMMA);
			}
			count++;
			Map<String,Object>  data=  dataList.get(i);
			String key=(String)data.get("name");
			
			keysql.append(key);
			valuesql.append("#{");
			valuesql.append(key);
			valuesql.append("}");
		}

		String sql = String.format("INSERT INTO %s (%s) VALUES(%s)", tabName,keysql,valuesql);
		return sql;
	}
	
	public String genUpdateSql(String tabName,List<Map<String,Object>> dataList,String where)throws SQLException{
		if(StringUtil.isEmpty(tabName)){
			throw new SQLException("table is null!");
		}
		if(dataList == null || dataList.size()==0){
			throw new SQLException("data is null!");
		}
		StringBuilder valuesql = new StringBuilder();
		
		int count =0;
		for (int i=0;i<dataList.size();i++) {
			Map<String,Object>  data=  dataList.get(i);
			String key=(String)data.get("name");
			String type=(String)data.get("type");
			if(count>0){
				valuesql.append(CHAR_COMMA);
			}
			count++;
			valuesql.append(key);
			valuesql.append("=");
			switch(type){
			case "short":
			case "int":
			case "double":
			case "float":
			case "byte":
			case "boolean":
			case "long":
			case "class java.lang.Integer":
			case "class java.lang.Long":
			case "class java.lang.Double":
					valuesql.append(data.get("value"));
					break;
				case "class java.lang.String":
				case "class java.math.BigDecimal":
					valuesql.append(CHAR_QUOTES);
					valuesql.append(data.get("value"));
					valuesql.append(CHAR_QUOTES);
					break;		
				default:
					break;
			}
		}

		String sql = String.format("UPDATE %s SET %s ", tabName,valuesql);
		if(where!=null&&where.length()>0)sql = sql + "where "+where;
		return sql;
	}
}
