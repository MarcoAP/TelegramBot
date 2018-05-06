package org.santander.produban.BDMBot.Controllers;

import java.io.IOException;

import org.santander.produban.BDMBot.Property;
import org.santander.produban.BDMBot.DTO.FowordMessageDTO;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class FowardMessageController {

	public HttpResponse<JsonNode> forwardMessage(FowordMessageDTO object) throws UnirestException, IOException {
		Unirest.setTimeouts(10000, 30000);
		return Unirest.post(new Property().getPropertyValues("ENDPOINT", "config") + "bot" + new Property().getPropertyValues("TOKEN", "config") + "/sendMessage")
				.field("chat_id", object.getChat_id())
				.field("from_chat_id", object.getFrom_chat_id())
				.field("message_id", object.getMessage_id())
				.asJson();
	}
	 
}
