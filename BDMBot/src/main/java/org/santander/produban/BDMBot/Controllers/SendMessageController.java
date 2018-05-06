package org.santander.produban.BDMBot.Controllers;

import java.io.IOException;

import org.santander.produban.BDMBot.Property;
import org.santander.produban.BDMBot.DTO.SendMessageDTO;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SendMessageController {

	public HttpResponse<JsonNode> sendMessage(SendMessageDTO object) throws UnirestException, IOException {
		// ObjectMapper mapper = new ObjectMapper();
		return Unirest.post(new Property().getPropertyValues("ENDPOINT", "config") + "bot" + new Property().getPropertyValues("TOKEN", "config") + "/sendMessage")
				// .body(mapper.writeValueAsString(send))
				.field("chat_id", object.getChat_id())
				.field("text", object.getText())
				.field("parse_mode", object.getParse_mode())
				.field("reply_markup", object.getReply_markup())
				.asJson();
	}


}
 