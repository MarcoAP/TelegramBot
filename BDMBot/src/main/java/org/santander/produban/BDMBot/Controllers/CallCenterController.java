package org.santander.produban.BDMBot.Controllers;

import java.io.IOException;
import java.util.Random;

import org.santander.produban.BDMBot.Property;
import org.santander.produban.BDMBot.DTO.SendMessageDTO;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CallCenterController {

	public void callCenter_pt(int chat_id) throws IOException, UnirestException{
		Unirest.setTimeouts(10000, 30000);
		SendMessageDTO callCenter = new SendMessageDTO();
		callCenter.setChat_id(Integer.toString(chat_id));
		String call = new Property().getPropertyValues("CALLCENTER", "pt_br");
		 
		Random minutosAleatorios = new Random();
		
		callCenter.setText(String.format(call, minutosAleatorios.nextInt(20)));
				
		new SendMessageController().sendMessage(callCenter);
	}
}
