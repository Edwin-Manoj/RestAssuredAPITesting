package resources;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utils {
	public static RequestSpecification Requestspec;
	ResponseSpecification Resposnespec;
	PrintStream log;
	
	
	public RequestSpecification RequestSpecification() throws IOException
	{		//Req spec
		if(Requestspec==null) {
		log = new PrintStream(new FileOutputStream("logging.txt"));
		Requestspec = new RequestSpecBuilder()
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setBaseUri(property("baseURL")).setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").build();
		return Requestspec;
		}
		return Requestspec;
	}
	
	public io.restassured.specification.ResponseSpecification ResponseSpecification()
	{		// Resp spec Builder
		Resposnespec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return Resposnespec;
	}
	
	public String property(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Users\\eclipse-java-2021-12-R-win32-x86_64\\eclipse\\Workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		String Property = prop.getProperty(key);
		return Property;
	}
	
	public String getJson(Response Response, String Key)
	{
		String Res = Response.asString();
		JsonPath JS = new JsonPath(Res);
		JS.get(Key);
		System.out.println("JsonPathValue "+JS.get(Key));
	    return JS.get(Key);
	}
}
