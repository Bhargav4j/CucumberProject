package com.project.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredWrapper {

	public Response response;
	private String uri;
	
	public void setResponse(Response response){
		this.response = response;
	}
	
	public void setUri(String uri){
		this.uri=uri;
	}
	
	public void sendRequest(String method, RequestSpecification reqSpec) {
		try {
		if (method.contains("Get")) {
		reqSpec.relaxedHTTPSValidation();
		Response response = reqSpec.when().get(uri);
		setResponse(response);
		}
		if (method.contains("Post")) {
		Response response = reqSpec.post(uri);
		setResponse(response);
		}
		if (method.contains("Put")) {
		Response response = reqSpec.put(uri);
		setResponse(response);
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
}
