package org.santander.produban.BDMBot.Controllers;

import java.io.IOException;

import org.santander.produban.BDMBot.Property;
import org.santander.produban.BDMBot.DTO.SendLocationDTO;
import org.santander.produban.BDMBot.DTO.SendMessageDTO;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class AboutUsController {

	public void aboutUs_pt(int chat_id) throws IOException, UnirestException{
		Unirest.setTimeouts(10000, 30000);
		StringBuilder sb = new StringBuilder();
		sb.append(new Property().getPropertyValues("ABOUT_INTRODUCTION", "pt_br"));
		
		SendMessageDTO sobre = new SendMessageDTO();
		sobre.setText(sb.toString());
		sobre.setChat_id(Integer.toString(chat_id));

		sobre.setReply_markup("{\"keyboard\":[],\"one_time_keyboard\":false}");
		new SendMessageController().sendMessage(sobre);

		SendLocationDTO localizacao = new SendLocationDTO();
		localizacao.setChat_id(sobre.getChat_id());
		localizacao.setLatitude(-23.6824736);
		localizacao.setLongitude(-46.6906717);
		
		new SendLocationController().sendLocation(localizacao);
	}
	
	public void aboutUs_en(int chat_id) throws IOException, UnirestException{
		Unirest.setTimeouts(10000, 30000);
		StringBuilder sb = new StringBuilder();
		sb.append(new Property().getPropertyValues("ABOUT_INTRODUCTION", "english"));
		
		SendMessageDTO sobre = new SendMessageDTO();
		sobre.setText(sb.toString());
		sobre.setChat_id(Integer.toString(chat_id));

		sobre.setReply_markup("{\"keyboard\":[],\"one_time_keyboard\":false}");
		new SendMessageController().sendMessage(sobre);

		SendLocationDTO localizacao = new SendLocationDTO();
		localizacao.setChat_id(sobre.getChat_id());
		localizacao.setLatitude(-23.6824736);
		localizacao.setLongitude(-46.6906717);
		
		new SendLocationController().sendLocation(localizacao);
	}
	
	public void aboutUs_sp(int chat_id) throws IOException, UnirestException{
		Unirest.setTimeouts(10000, 30000);
		StringBuilder sb = new StringBuilder();
		sb.append(new Property().getPropertyValues("ABOUT_INTRODUCTION", "spanish"));
		 
		SendMessageDTO sobre = new SendMessageDTO();
		sobre.setText(sb.toString());
		sobre.setChat_id(Integer.toString(chat_id));

		sobre.setReply_markup("{\"keyboard\":[],\"one_time_keyboard\":false}");
		new SendMessageController().sendMessage(sobre);

		SendLocationDTO localizacao = new SendLocationDTO();
		localizacao.setChat_id(sobre.getChat_id());
		localizacao.setLatitude(-23.6824736);
		localizacao.setLongitude(-46.6906717);
		
		new SendLocationController().sendLocation(localizacao);
	}
}
