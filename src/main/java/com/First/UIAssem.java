package com.First;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.security.Principal;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

//@WebServlet(urlPatterns={ "/*" })
public class UIAssem extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	@Override
	public void init(ServletConfig config){
		
		/*Properties props=new Properties();
		props.put("resource.loader", "custom");
		
		try {
			Velocity.init(props);
			
			Annotation[] annotations=this.getClass().getAnnotations();
			//System.out.println(annotations.toString());
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("in init of UIAssem");
		
	}
    
    public UIAssem() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		    /*VelocityEngine ve = new VelocityEngine();
		    Properties props = new Properties();
		    // THIS PATH CAN BE HARDCODED BUT IDEALLY YOUD GET IT FROM A PROPERTIES FILE
		    String path = "‪C://Users//vivek.kumar5//Desktop//";
		    props.put("file.resource.loader.path", path);
		    props.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
		    try {
				ve.init(props);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
		    Template template;
			try {
				template = ve.getTemplate("xyz.tmpl");
				 VelocityContext context = new VelocityContext();
			        context.put("lastName", "Mavis");
			        context.put("firstName", "Roger");
			        context.put("email", "mrRogers@wmail.com");
			        context.put("title", "Mr.");

				      StringWriter writer = new StringWriter();
				      template.merge(context, writer );
				      System.out.println( writer.toString());
				      String velocityHtml = writer.toString();
				      
				    System.out.println(velocityHtml.toString());
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseErrorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		
		System.out.println("in doget");
		 
		   
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
