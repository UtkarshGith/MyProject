package Assignment.qat;
import org.testng.Assert;
import org.testng.annotations.Test;

import ConvertResponseToPojo.Data;
import ConvertResponseToPojo.EmployeeData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import com.google.gson.Gson;

public class APITest 
{
	
	Readconfig rc=new Readconfig();
	String Api=rc.readConfig();

    int employee_id;
    String s,s1;
    
    
	@Test
	public void performget()
	{
		
		Response res1=ApiUtils.performGet(Api+"employees");
		int statuscode=res1.getStatusCode();
		Assert.assertEquals(statuscode,200,"Correct status code returned");
		
		
	};
	@Test
	public void performpost( )
	{
		String payload="{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
		Response res1=ApiUtils.performPost(Api+"create",payload);
		EmployeeData root=res1.getBody().as(EmployeeData.class);
		Data d=new Data();
		d=root.data;
		employee_id=d.id;
		s=d.name;
		s1=d.age;
		System.out.println("Ans--->"+root.status);
		System.out.println(employee_id);
		System.out.println(s);
		System.out.println(s1);
		int statuscode=res1.getStatusCode();
		Assert.assertEquals(statuscode,200,"Correct status code returned"); 
		
	};
	
	
	@Test
	public void performGetById()
	{
		
		Response res1=ApiUtils.performGet(Api+"employee/"+employee_id);
		int statuscode=res1.getStatusCode();
	   //System.out.println("Ans---->"+s);
		Assert.assertEquals(statuscode,200,"Correct status code returned");
		
		
	};
	@Test
	public void performput() 
	{
		String payload="{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
		Response res1=ApiUtils.performPut(	Api+"update/21",payload);
		System.out.println("performput "+res1.getStatusLine());
		int statuscode=res1.getStatusCode();
		Assert.assertEquals(statuscode,200,"Correct status code returned");
	};
	@Test
	public void performdelete()
	{
		
		Response res1=ApiUtils.performDelete(Api+"delete/2");
		System.out.println("performdelete "+res1.getStatusLine());
		int statuscode=res1.getStatusCode();
		Assert.assertEquals(statuscode,200,"Correct status code returned");
	};
	
	
	

};
