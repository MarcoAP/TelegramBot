package org.santander.produban.BDMBot.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.santander.produban.BDMBot.DTO.SendMessageDTO;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SelectLanguageController {

	public void selectLanguage(int chat_id) throws UnirestException, IOException {
		Unirest.setTimeouts(10000, 30000);
		SendMessageDTO idioma = new SendMessageDTO();
		idioma.setText("<< Selecione o seu idioma | Select your language | Elige tu idioma >>");
		// idioma.setParse_mode("bold");
		idioma.setChat_id(Integer.toString(chat_id));
		StringBuffer sb = new StringBuffer();
		List<StringBuffer> l = new ArrayList<StringBuffer>();

		// Brazil - Flag
		sb = new StringBuffer();
		sb.append(Character.toChars(127463));
		sb.append(Character.toChars(127479));
		l.add(sb);

		// Spain - Flag
		sb = new StringBuffer();
		sb.append(Character.toChars(127466));
		sb.append(Character.toChars(127480));
		l.add(sb);

		// United States - Flag
		sb = new StringBuffer();
		sb.append(Character.toChars(127482));
		sb.append(Character.toChars(127480));
		l.add(sb);
 
		idioma.setReply_markup("{\"keyboard\":[[\" " + l.get(0) + " Português\"],[\" " + l.get(1) + " Español\"],[\" "
				+ l.get(2) + " English\"]],\"one_time_keyboard\":false}");
		new SendMessageController().sendMessage(idioma);
	}
}
