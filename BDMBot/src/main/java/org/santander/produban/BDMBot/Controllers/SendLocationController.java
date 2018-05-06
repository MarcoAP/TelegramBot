package org.santander.produban.BDMBot.Controllers;

import java.io.IOException;

import org.santander.produban.BDMBot.Property;
import org.santander.produban.BDMBot.DTO.SendLocationDTO;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SendLocationController {

	public HttpResponse<JsonNode> sendLocation(SendLocationDTO object) throws UnirestException, IOException {
		// ObjectMapper mapper = new ObjectMapper();
		Unirest.setTimeouts(10000, 30000);
		return Unirest.post(new Property().getPropertyValues("ENDPOINT", "config") + "bot" + new Property().getPropertyValues("TOKEN", "config") + "/sendLocation")
				// .body(mapper.writeValueAsString(send))
				.field("chat_id", object.getChat_id())
				.field("latitude", object.getLatitude())
				.field("longitude", object.getLongitude())
				//.field("reply_markup", object.getReply_markup())
				.asJson();
	}
	
} 
