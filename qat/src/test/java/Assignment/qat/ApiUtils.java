package Assignment.qat;

// import org.testng.annotations.Test ;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ApiUtils {
	/*
	 Perform Get Operation
	 input-  base URL
	 return-response
	 */
	public static Response performGet(String url)
	{
		Response res=
		(Response) given()
		 
	    .when()
	       .get(url)
	     .then().extract();
	       
	  return res ;    	
	}
	/*
	 Perform Post Operation
	 input-  base URL,Payload
	 return-response
	 */
	public static Response performPost(String url,String Payload)
	{
		Response res=
		(Response) given()
		   .contentType("application/json")
		   .body(Payload)
		.when()
		   .post(url)
		.then().extract(); 
		 return res;		
	}
	/*
	 Perform Put Operation
	 input-  base URL,payload
	 return-response
	 */
	public static Response performPut(String url,String Payload)
	{
	Response res=	
	(Response) given()
	    .contentType("application/json")
	    .body(Payload)
	.when() 
	    .put(url)
	.then().extract();
	   return res;
	}
	/*
	 Perform Delete Operation
	 input-  base URL
	 return-response
	 */
	
	public static Response performDelete(String url)
	{	
		Response res=
	(Response) given() 
		
		
		.when() 
		    .delete(url)
		.then().extract();
		   
		return res;
	    
	}
  
  
}

