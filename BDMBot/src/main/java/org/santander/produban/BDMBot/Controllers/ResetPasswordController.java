package org.santander.produban.BDMBot.Controllers;

import java.io.IOException;

import org.santander.produban.BDMBot.Property;
import org.santander.produban.BDMBot.DTO.SendMessageDTO;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ResetPasswordController {

	public void resetPassword_pt(int chat_id) throws IOException, UnirestException{
		Unirest.setTimeouts(10000, 30000);
		SendMessageDTO resetPassword = new SendMessageDTO();
		resetPassword.setChat_id(Integer.toString(chat_id));
		resetPassword.setText(new Property().getPropertyValues("RESETPASS", "pt_br"));
				
		new SendMessageController().sendMessage(resetPassword);
	}
	
	public void resetPassword_sp(int chat_id) throws IOException, UnirestException{
		Unirest.setTimeouts(10000, 30000);
		SendMessageDTO resetPassword = new SendMessageDTO();
		resetPassword.setChat_id(Integer.toString(chat_id));
		resetPassword.setText(new Property().getPropertyValues("RESETPASS", "spanish"));
				
		new SendMessageController().sendMessage(resetPassword);
	} 
	
	public void resetPassword_en(int chat_id) throws IOException, UnirestException{
		Unirest.setTimeouts(10000, 30000);
		SendMessageDTO resetPassword = new SendMessageDTO();
		resetPassword.setChat_id(Integer.toString(chat_id));
		resetPassword.setText(new Property().getPropertyValues("RESETPASS", "english"));
				
		new SendMessageController().sendMessage(resetPassword);
	}
	
}
