package Assignment.qat;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class Readconfig {

	Properties prop;
	
	public String readConfig() 
	{
		
		File src=new File("/Users/utkarshsingh/git/Mytask1/qat/src/test/java/Assignment/qat/urls.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
			System.out.println(src);
			return  prop.getProperty("url");
		}catch(Exception e)
		{

			System.out.println(e.getMessage());
			
		}
		//System.out.println(prop.getProperty("URL"));
		return "" ;
		
		
	}

	
	
};
