package org.santander.produban.BDMBot.Controllers;

import java.io.IOException;

import org.santander.produban.BDMBot.Property;
import org.santander.produban.BDMBot.DTO.SendPhotoDTO;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SendPhotoController {

	public HttpResponse<JsonNode> sendPhoto(SendPhotoDTO object) throws UnirestException, IOException {
		// ObjectMapper mapper = new ObjectMapper();
		Unirest.setTimeouts(10000, 30000);
		return Unirest.post(new Property().getPropertyValues("ENDPOINT", "config") + "bot" + new Property().getPropertyValues("TOKEN_YJOB", "config") + "/sendPhoto")
				// .body(mapper.writeValueAsString(send))
				.field("chat_id", object.getChat_id())
				.field("photo", object.getPhoto())
				.field("caption", object.getCaption())
				.asJson();
	}
 
}
