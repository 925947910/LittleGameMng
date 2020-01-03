package com.cointer.interceptor;


import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import com.cointer.redis.IJedisClient;
import com.cointer.redis.RedisData;
import com.cointer.constant.Constant;
import com.cointer.constant.StatusCode;
import com.cointer.controller.base.BaseController;



@Component
public class LoginInterceptor extends BaseInterceptor implements HandlerInterceptor {

	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	private static final Set<String> NOT_INTERCEPT_URI = new HashSet<>();//不拦截的URI

	static {
		NOT_INTERCEPT_URI.add("/GameUser/user/registOrLogin");
	}
	@Autowired
	private   IJedisClient jedisClient;
	/**
	 * 在请求处理之前进行调用（Controller方法调用之前）
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		String uri = request.getRequestURI();
		if (NOT_INTERCEPT_URI.contains(uri)) {
			return true;
		}
		String  session=request.getParameter(Constant._SESSION);
		if(session == null) {
			send(response, BaseController.failed(StatusCode.NO_LOGIN, "用户未登陆:"+uri, null));
			return false;
		}
		if(RedisData.authSession(jedisClient, session)==null) {
			send(response, BaseController.failed(StatusCode.NO_LOGIN, "用户未登陆:"+uri, null));
			return false;
		}
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView mv) throws Exception {
		
		
		
	}

	/**
	 * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行
	 * （主要是用于进行资源清理工作）
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex) throws Exception {
	}
	
	
}