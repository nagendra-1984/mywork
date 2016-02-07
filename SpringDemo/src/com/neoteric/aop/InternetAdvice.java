package com.neoteric.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;


public class InternetAdvice implements MethodBeforeAdvice,AfterReturningAdvice,MethodInterceptor{
	
	private CafeOwner cafeOwner;

	public CafeOwner getCafeOwner() {
		return cafeOwner;
	}

	public void setCafeOwner(CafeOwner cafeOwner) {
		this.cafeOwner = cafeOwner;
	}

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		// TODO Auto-generated method stub
		this.cafeOwner.loginTime();
	}

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		// TODO Auto-generated method stub
		this.cafeOwner.loggedOutTime();
		
	}

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		// TODO Auto-generated method stub
		
		System.out.println("^%^ Allocate System ^%^");
		method.proceed();
		System.out.println("^%^ De-allocate System ^%^");
		return null;
	}


}
