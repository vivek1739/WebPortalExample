package com.TestPortal;

import org.bson.Document;

import com.Dao.MongoConn;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Validate {
	
	public static Validate validate=new Validate();

	private Validate(){
		//singleTon design pattern
	}
	
	public static Validate getValidate() {
		return validate;
	}
	
	public String checkDB(Login obj)
	{
		/*MongoDatabase database=MongoConn.getMongoConn().mongoClient.getDatabase("test");
		MongoCollection<Document> collection = database.getCollection("innUsers"); // got the collection a
		MongoCursor<Document> iterator = collection.find().iterator(); // get one document at a time
		String username,password;
		while(iterator.hasNext())
		{
			Document next = iterator.next();
			username=next.get("username").toString();
			password=next.get("password").toString();
			if(username.equals(obj.getUsername()) && password.equals(obj.getPassword()))
			{
				System.out.println("yes");
				return "yes";
			}
		}
		System.out.println("no");*/
		return "no";
		
	}

}
