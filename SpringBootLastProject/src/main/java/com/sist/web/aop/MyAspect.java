package com.sist.web.aop;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class MyAspect {
	@After("execution(* com.sist.web.controller.*Controller.*(..))") //controller 전체
	public void after() throws Exception
	{
		HttpServletResponse response=((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getResponse();
		response.sendRedirect("../news/news_aop_react");
	}
}
