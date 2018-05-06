package org.santander.produban.BDMBot.Controllers;

import java.io.IOException;

import org.santander.produban.BDMBot.Property;
import org.santander.produban.BDMBot.DTO.SendMessageDTO;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class NotificationsConfigure {

	public void iniciarNotificacao_pt(int chat_id, int reply) throws IOException, UnirestException {
		Unirest.setTimeouts(10000, 30000);
		StringBuilder sb = new StringBuilder();
		sb.append(new Property().getPropertyValues("START_NOTIFICATIONS", "pt_br"));

		SendMessageDTO iniciarNotificacoes = new SendMessageDTO();
		iniciarNotificacoes.setText(sb.toString());
		iniciarNotificacoes.setChat_id(Integer.toString(chat_id));
		iniciarNotificacoes.setReply_to_message_id(reply);
 
		iniciarNotificacoes.setReply_markup("{\"keyboard\":[],\"one_time_keyboard\":false}");
		new SendMessageController().sendMessage(iniciarNotificacoes);
	}

	public void startNotifications_en(int chat_id, int reply) throws IOException, UnirestException {
		Unirest.setTimeouts(10000, 30000);
		StringBuilder sb = new StringBuilder();
		sb.append(new Property().getPropertyValues("START_NOTIFICATIONS", "english"));

		SendMessageDTO startNotifications = new SendMessageDTO();
		startNotifications.setText(sb.toString());
		startNotifications.setChat_id(Integer.toString(chat_id));
		startNotifications.setReply_to_message_id(reply);

		startNotifications.setReply_markup("{\"keyboard\":[],\"one_time_keyboard\":false}");
		new SendMessageController().sendMessage(startNotifications);
	}

	public void iniciarNotificaciones_sp(int chat_id, int reply) throws IOException, UnirestException {
		Unirest.setTimeouts(10000, 30000);
		StringBuilder sb = new StringBuilder();
		sb.append(new Property().getPropertyValues("START_NOTIFICATIONS", "spanish"));

		SendMessageDTO iniciarNotificaciones = new SendMessageDTO();
		iniciarNotificaciones.setText(sb.toString());
		iniciarNotificaciones.setChat_id(Integer.toString(chat_id));
		iniciarNotificaciones.setReply_to_message_id(reply);

		iniciarNotificaciones.setReply_markup("{\"keyboard\":[],\"one_time_keyboard\":false}");
		new SendMessageController().sendMessage(iniciarNotificaciones);
	}

	public void pararNotificacao_pt(int chat_id, int reply) throws IOException, UnirestException {
		Unirest.setTimeouts(10000, 30000);
		StringBuilder sb = new StringBuilder();
		sb.append(new Property().getPropertyValues("STOP_NOTIFICATIONS", "pt_br"));

		SendMessageDTO iniciarNotificacoes = new SendMessageDTO();
		iniciarNotificacoes.setText(sb.toString());
		iniciarNotificacoes.setChat_id(Integer.toString(chat_id));
		iniciarNotificacoes.setReply_to_message_id(reply);

		iniciarNotificacoes.setReply_markup("{\"keyboard\":[],\"one_time_keyboard\":false}");
		new SendMessageController().sendMessage(iniciarNotificacoes);
	}

	public void stopNotifications_en(int chat_id, int reply) throws IOException, UnirestException {
		Unirest.setTimeouts(10000, 30000);
		StringBuilder sb = new StringBuilder();
		sb.append(new Property().getPropertyValues("STOP_NOTIFICATIONS", "english"));

		SendMessageDTO startNotifications = new SendMessageDTO();
		startNotifications.setText(sb.toString());
		startNotifications.setChat_id(Integer.toString(chat_id));
		startNotifications.setReply_to_message_id(reply);

		startNotifications.setReply_markup("{\"keyboard\":[],\"one_time_keyboard\":false}");
		new SendMessageController().sendMessage(startNotifications);
	}

	public void pararNotificaciones_sp(int chat_id, int reply) throws IOException, UnirestException {
		Unirest.setTimeouts(10000, 30000);
		StringBuilder sb = new StringBuilder();
		sb.append(new Property().getPropertyValues("STOP_NOTIFICATIONS", "spanish"));

		SendMessageDTO iniciarNotificaciones = new SendMessageDTO();
		iniciarNotificaciones.setText(sb.toString());
		iniciarNotificaciones.setChat_id(Integer.toString(chat_id));
		iniciarNotificaciones.setReply_to_message_id(reply);

		iniciarNotificaciones.setReply_markup("{\"keyboard\":[],\"one_time_keyboard\":false}");
		new SendMessageController().sendMessage(iniciarNotificaciones);
	}
}
