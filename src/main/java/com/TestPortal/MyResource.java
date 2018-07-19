package com.TestPortal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.struts.chain.commands.servlet.SetContentType;

import com.Dao.MysqlDao;
import com.Secure.SetCookie;
import com.Secure.ThreadLocalInfoContainer;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    @POST
    @Path("country")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt()  {
    	MysqlDao mysqlDao = MysqlDao.getMysqlDao();
    	List<Country> countryData = mysqlDao.getCountryData();
    	GenericEntity list = new GenericEntity<List<Country>>(countryData) {};
    	//Map<String, Object> threadLocalHashtable=ThreadLocalInfoContainer.INFO_CONTAINER.get();
		//Object name = threadLocalHashtable.get("username");
		//System.out.println("username from thread local is :"+(String)name);
    	return Response.status(Status.OK).entity(list).build();
    }
    
    
    @GET
    @Path("index")
    public File getIndex()
    {
    	File file=new File("D://RestSpace//TestPortal//src//main//webapp//index.html");
    	return file;
    	
    }
    
    @GET
    @Path("name")
    @Produces({MediaType.TEXT_PLAIN})
    public String getName()
    {
    	Map<String, Object> threadLocalHashtable=ThreadLocalInfoContainer.INFO_CONTAINER.get();
    	Object name = threadLocalHashtable.get("username");
    	System.out.println("name is called");
    	return name.toString();

    }
    
    @GET
    @Path("auth")
    public Response getAuth()
    {
    	SetCookie sc=new SetCookie();
    	String cookie = sc.getCookie();
    	//System.out.println(cookie);
    	NewCookie nc=new NewCookie("Token", cookie);
    	return Response.status(Status.OK).cookie(nc).build();
    }
    
    
    
  
    
    
    @GET
	@Path("wel")
	@Produces(MediaType.TEXT_HTML)
	public InputStream getLoginPage() throws FileNotFoundException
	{
		File f = new File("D:\\RestSpace\\TestPortal\\src\\main\\webapp\\Welcome.html");
		
		return new FileInputStream(f);
	}
	
    @POST
    @Path("qparam")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(@QueryParam ("start") String start,@QueryParam ("stop") String stop)
    {
    	System.out.println("in test");
    	return (start+" "+stop);
    }
    
    @POST
    @Path("login")
  //  @Produces(MediaType.TEXT_PLAIN)
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public String login(Login obj)
    {
    	String cookieData=null;
    	String token=Validate.getValidate().checkDB(obj);
    	if(token.equals("yes")){
    		
    	cookieData=EncryptData.getEncryptData().encrypt(obj);
    	//System.out.println("cookie data:"+cookieData);
    	return cookieData;
    	}
    	return "no";
    }
    
}
