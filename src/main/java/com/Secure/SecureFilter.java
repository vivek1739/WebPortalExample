package com.Secure;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.iterators.EntrySetMapIterator;

//@WebFilter(urlPatterns={"/wel","/country"})
public class SecureFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse, FilterChain paramFilterChain)
			throws IOException, ServletException {
		
	/*	HttpServletRequest httpRequest=null;
		if(paramServletRequest instanceof HttpServletRequest){
			System.out.println("URI INFO ::::: "+((HttpServletRequest) paramServletRequest).getRequestURI().toString());
			if(((HttpServletRequest) paramServletRequest).getRequestURI().contains("webapi")){
			System.out.println("yes , request is an instance of httpServeletReq");
			httpRequest=(HttpServletRequest)paramServletRequest;
			
			if(httpRequest.getUserPrincipal().getName()!=null){
			String name = httpRequest.getUserPrincipal().getName();
			this.setThreadLocalValues("username", name);
			System.out.println("name of user is "+name);
			}
		}}
		else
			System.out.println("No ,request is not an instance of httpServeletReq");*/
		paramFilterChain.doFilter(paramServletRequest, paramServletResponse);
		return;	
	}
	private void setThreadLocalValues(String name, Object value){
		
		if(ThreadLocalInfoContainer.INFO_CONTAINER.get()==null){
			
			Hashtable<String, Object> threadLocalHashtable=new Hashtable<String, Object>(5);
			threadLocalHashtable.put(name, value);
			ThreadLocalInfoContainer.INFO_CONTAINER.set(threadLocalHashtable);	
		}
		else{
			Map<String, Object> threadLocalHashtable=ThreadLocalInfoContainer.INFO_CONTAINER.get();
			threadLocalHashtable.put(name, value);
		}
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub	
	}
}
