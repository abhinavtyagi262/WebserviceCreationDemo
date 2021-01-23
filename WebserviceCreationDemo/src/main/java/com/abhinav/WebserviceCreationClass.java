package com.abhinav;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Path("/")
public class WebserviceCreationClass {
	
	private static Logger log = LoggerFactory.getLogger(WebserviceCreationClass.class.getName());
	
	@Path("WebservicePath")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String WebserviceCreationMethod(InputStream inputStream) {
		
		StringBuilder stringBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while((line = in.readLine())!=null) {
				stringBuilder.append(line);
			}
		}	
		catch(Exception e) {
			log.error("Error occurred while reading inputStream: " + e );
		}
		
		String requestString = new String(stringBuilder.toString());
		log.info("Request is: " + requestString);
		System.out.println("Request is: " + requestString);
		
		String responseString = requestString;
		log.info("Response is: " + responseString);
		System.out.println("Response is: " + responseString);
		
		return responseString;
	}
}
