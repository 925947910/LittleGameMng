package com.cointer.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;


public abstract class BaseInterceptor {

	/*返回客户端数据*/
	public void send(HttpServletResponse response, String json) throws Exception{
		PrintWriter writer = null;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		try {
			writer = response.getWriter();
			writer.print(json);
		} catch (IOException e) {
		} finally {
			if (writer != null)
				writer.close();
		}
	}





}
