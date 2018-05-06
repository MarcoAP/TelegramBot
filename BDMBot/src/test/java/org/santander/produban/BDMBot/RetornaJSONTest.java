package org.santander.produban.BDMBot;

import java.awt.PageAttributes.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;

public class RetornaJSONTest {

	private static final String token = "279179354:AAHnUGhlkOj07KsfFvdyQ--CMcf5ZBTcAMQ";

	public static void main2(String[] args) {
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet("https://api.telegram.org/bot" + token + "/sendMessage");
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			httpClient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ClientResource resource = new ClientResource("https://api.telegram.org/bot" + token + "/sendMessage");

		//resource.setMethod(Method.POST);
		//resource.getReference().addQueryParameter("format", "json");
		//resource.getReference().addQueryParameter("access_key", "8QON4KC7BMAYYBCEX");
		System.out.println(resource);
		JSONObject obj = new JSONObject();
		try {
//			obj.put("partId", "23");
//			obj.put("carId", "34");
//			obj.put("name", "chassis");
//			obj.put("section", "frame");
		} catch (JSONException e1) {// handling of exception

		}

		StringRepresentation stringRep = new StringRepresentation(obj.toString());
		//stringRep.setMediaType(MediaType.APPLICATION_JSON);

		try {
			resource.post(stringRep).write(System.out); // exception occurs here
		} catch (Exception e) {// handling of exceptions
		}
	}

}
