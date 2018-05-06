package org.santander.produban.BDMBot;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.santander.produban.BDMBot.Controllers.AboutUsController;
import org.santander.produban.BDMBot.Controllers.CallCenterController;
import org.santander.produban.BDMBot.Controllers.NotificationsConfigure;
import org.santander.produban.BDMBot.Controllers.ResetPasswordController;
import org.santander.produban.BDMBot.Controllers.SelectLanguageController;
import org.santander.produban.BDMBot.Controllers.SendMessageController;
import org.santander.produban.BDMBot.Controllers.SprintController;
import org.santander.produban.BDMBot.DTO.SendMessageDTO;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public final class TelegramBot extends Thread{

	protected String getEndpoint() {
		try {
			return new Property().getPropertyValues("ENDPOINT", "config");
		} catch (IOException e) {
			System.err.println("Erro ao obter propriedade TOKEN: " + e.getMessage());
		}
		return null;
	}

	protected String getToken() {
		try {
			return new Property().getPropertyValues("TOKEN", "config");
		} catch (IOException e) {
			System.err.println("Erro ao obter propriedade ENDPOINT: " + e.getMessage());
		}
		return null;
	}

	public HttpResponse<JsonNode> getUpdates(Integer offset) throws UnirestException, IOException {
		return Unirest.post(getEndpoint() + "bot" + getToken() + "/getUpdates")
				.field("offset", offset)
				.asJson();
	}
	
	public void run() {
		int last_update_id = 0; // controle das mensagens processadas
		HttpResponse<JsonNode> response;

		while (true) {
			try {


				response = getUpdates(last_update_id++);
				if (response.getStatus() == 200) {

					JSONArray responses = response.getBody().getObject().getJSONArray("result");
					System.out.println(responses);
					if (responses.isNull(0)) {
						continue;
					} else {
						last_update_id = responses.getJSONObject(responses.length() - 1).getInt("update_id") + 1;
					}

					for (int i = 0; i < responses.length(); i++) {
						JSONObject message = responses.getJSONObject(i).getJSONObject("message");
						Unirest.setTimeouts(10000, 30000);
						int chat_id = message.getJSONObject("chat").getInt("id");
						String texto = message.getString("text");
						int message_id = message.getInt("message_id");
						String first_name = message.getJSONObject("from").getString("first_name");
						//String last_name = message.getJSONObject("from").getString("last_name");
						
						if (texto.trim().equalsIgnoreCase("/sobre")) {
							new AboutUsController().aboutUs_pt(chat_id);						
						} else 
							if (texto.trim().equalsIgnoreCase("/about")) {
								new AboutUsController().aboutUs_en(chat_id);
							} else 
								if (texto.trim().equalsIgnoreCase("/acerca")) {
									new AboutUsController().aboutUs_sp(chat_id);
								}
						
						if (texto.trim().equalsIgnoreCase("/pararnotificacoes")) {
							new NotificationsConfigure().pararNotificacao_pt(chat_id, message_id);						
						} else 
							if (texto.trim().equalsIgnoreCase("/paradanotificaciones")) {
								new NotificationsConfigure().pararNotificaciones_sp(chat_id, message_id);
							} else 
								if (texto.trim().equalsIgnoreCase("/stopnotifications")) {
									new NotificationsConfigure().stopNotifications_en(chat_id, message_id);
								}

						if (texto.trim().equalsIgnoreCase("/iniciarnotificacacoes")) {
							new NotificationsConfigure().iniciarNotificacao_pt(chat_id, message_id);						
						} else 
							if (texto.trim().equalsIgnoreCase("/iniciarnotificaciones")) {
								new NotificationsConfigure().iniciarNotificaciones_sp(chat_id, message_id);
							} else 
								if (texto.trim().equalsIgnoreCase("/startnotifications")) {
									new NotificationsConfigure().startNotifications_en(chat_id, message_id);
								}
						
						if (texto.trim().equalsIgnoreCase("/autor") || texto.trim().equalsIgnoreCase("/author")) {
							SendMessageDTO mess = new SendMessageDTO();
							mess.setChat_id(Integer.toString(chat_id));
							mess.setText("Este BOT foi desenvolvido pelo colaborador MARCO ANTONIO PEREIRA\n\nLinkedin: https://www.linkedin.com/in/marcoap\n\nContato: +55 11 975 124 988");
							new SendMessageController().sendMessage(mess);						
						} 
						
						if (texto.trim().equalsIgnoreCase("/workus")){
							SendMessageDTO mess = new SendMessageDTO();
							mess.setChat_id(Integer.toString(chat_id));
							mess.setText("We will publish our job offers on our website Linkedin: https://www.linkedin.com/company/produban");
							new SendMessageController().sendMessage(mess);
						} else 
							if (texto.trim().equalsIgnoreCase("/trabalheconosco")){
								SendMessageDTO mess = new SendMessageDTO();
								mess.setChat_id(Integer.toString(chat_id));
								mess.setText("Publicaremos nossas ofertas de emprego em nossa página do Linkedin: https://www.linkedin.com/company/produban");
								new SendMessageController().sendMessage(mess);
							} else 
								if (texto.trim().equalsIgnoreCase("/trabajaconnosotros")){
									SendMessageDTO mess = new SendMessageDTO();
									mess.setChat_id(Integer.toString(chat_id));
									mess.setText("Vamos a publicar nuestras ofertas de trabajo en nuestra página web Linkedin: https://www.linkedin.com/company/produban");
									new SendMessageController().sendMessage(mess);
								}
						
						if (texto.trim().equalsIgnoreCase("/sprint")) {
							new SprintController().sprint_pt_br(chat_id);						
						} 
						
						if (texto.trim().equalsIgnoreCase("/callcenter")) {
							new CallCenterController().callCenter_pt(chat_id);						
						} 
						
						if (texto.trim().equalsIgnoreCase("/resetsenha")) {
							new ResetPasswordController().resetPassword_pt(chat_id);						
						} else 
							if (texto.trim().equalsIgnoreCase("/resetpassord")) {
								new ResetPasswordController().resetPassword_en(chat_id);
							} 
						
						if (texto.trim().equalsIgnoreCase("/ProdubanStart") || 
								texto.trim().equalsIgnoreCase("/start") ||
								texto.trim().equalsIgnoreCase("/idioma") ||
								texto.trim().equalsIgnoreCase("/language") ||
								texto.trim().equalsIgnoreCase("/help") || 
								texto.trim().equalsIgnoreCase("/ajuda") || 
								texto.trim().equalsIgnoreCase("/ayuda")) {

							new SelectLanguageController().selectLanguage(chat_id);
						}
						
						
						if (texto.trim().equalsIgnoreCase(new StringBuffer().append(Character.toChars(127463)).append(Character.toChars(127479)) + " Português")) {
							SendMessageDTO object = new SendMessageDTO();
							object.setChat_id(Integer.toString(chat_id));
							
							StringBuffer sb = new StringBuffer();
							sb.append(
									"/produbanstart - Iniciar o BOT\n"
									+ "/pararnotificacoes - Interrompe todas as notificações\n"
									+ "/iniciarnotificacacoes - Retorna ao envio de todas as notificações\n"
									+ "/idioma - Configura o idioma para o utilizador\n"
									+ "/resetsenha - Reset de senha de login de rede (necessário token)\n"
									+ "/sprint - Acompanhamento das próximas entregas no Sprint corrente\n"
									+ "/sobre - Sobre a PRODUBAN, conheça-nos\n"
									+ "/callcenter - Seja atendido por um representante PRODUBAN via aplicativo\n"
									+ "/trabalheconosco - Envie seu perfil do Linkedin para nosso recursos humanos\n"
									+ "/ajuda - Lista de comandos disponíveis");
							object.setText(sb.toString());
							new SendMessageController().sendMessage(object);
						} else
							if(texto.trim().equalsIgnoreCase(new StringBuffer().append(Character.toChars(127466)).append(Character.toChars(127480)) + " Español")){
								SendMessageDTO object = new SendMessageDTO();
								object.setChat_id(Integer.toString(chat_id));
								
								StringBuffer sb = new StringBuffer();
								sb.append(
										"/produbanstart - Iniciar BOT\n"
										+ "/paradanotificaciones - Detiene todas las notificaciones\n"
										+ "/iniciarnotificaciones - Devuelve enviar todas las notificaciones\n"
										+ "/idioma - Establece el idioma para el usuario\n"
										+ "/resetsenha - restablecimiento de la red de acceso de contraseña (token requerido)\n"
										+ "/sprint - Seguimiento de las próximas entregas en el Sprint actual\n"
										+ "/acerca - Sobre Produban, conocernos\n"
										+ "/callcenter - con la presencia de un representante Produban via aplicativo\n"
										+ "/trabajaconnosotros - Envíe su perfil de LinkedIn a nuestros recursos humanos\n"
										+ "/ayuda - Lista de comandos disponibles");
								object.setText(sb.toString());
								new SendMessageController().sendMessage(object);
							} else 
								if(texto.trim().equalsIgnoreCase(new StringBuffer().append(Character.toChars(127482)).append(Character.toChars(127480)) + " English")) {
									SendMessageDTO object = new SendMessageDTO();
									object.setChat_id(Integer.toString(chat_id));
									
									StringBuffer sb = new StringBuffer();
									sb.append(
											"/produbanstart - Start BOT\n"
											+ "/stopnotifications - Stops all notifications\n"
											+ "/startnotifications - Returns to send all notifications\n"
											+ "/language - Sets the language for the user\n"
											+ "/resetpassord - network login password reset (required token)\n"
											+ "/sprint - Monitoring the next deliveries in the current Sprint\n"
											+ "/about - About Produban, know us\n"
											+ "/callcenter - Be attended by a representative Produban by application\n"
											+ "/workus - Send your Linkedin profile to our human resources\n"
											+ "/help - Command List available");
									object.setText(sb.toString());
									new SendMessageController().sendMessage(object);
						}
					}
				}
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			} 
			
		}
	}
}
