package org.santander.produban.BDMBot.Controllers;

import java.io.IOException;

import org.santander.produban.BDMBot.Property;
import org.santander.produban.BDMBot.DTO.SendMessageDTO;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SprintController {
	
	public void sprint_pt_br(int chat_id) throws IOException, UnirestException{
		Unirest.setTimeouts(10000, 30000);
		SendMessageDTO sprint = new SendMessageDTO();
		sprint.setChat_id(Integer.toString(chat_id));
		sprint.setText(new Property().getPropertyValues("SPRINT", "pt_br"));
		
		new SendMessageController().sendMessage(sprint);
	}
	
}
 