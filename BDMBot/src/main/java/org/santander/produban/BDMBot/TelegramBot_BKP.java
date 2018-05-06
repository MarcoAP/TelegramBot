package org.santander.produban.BDMBot;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public final class TelegramBot_BKP {
	   	private final String endpoint = "https://api.telegram.org/";
	    private final String token;

	    public TelegramBot_BKP(String token) {
	        this.token = token;
	    }

	    public HttpResponse<JsonNode> sendMessage(Integer chatId, String text) throws UnirestException {
	        return Unirest.post(endpoint + "bot" + token + "/sendMessage")
	                .field("chat_id", chatId)
	                .field("text", text)
	                .asJson();
	    }
	    
	    public HttpResponse<JsonNode> sendMessageToMarco(String text) throws UnirestException {
	        //return Unirest.post(endpoint + "bot" + token + "/sendMessage")
	    	//return Unirest.post(endpoint + "bot" + token + "/forwardMessage")
	    	return Unirest.post(endpoint + "bot" + token + "/getChat")
	    			.field("chat_id", 96678139) // Marco
	    			//.field("chat_id", 162152897) // Gabriel
	                //.field("from_chat_id", 96678139)
	                //.field("message_id", 645)
	    			//.field("action", "+55 (11) 975 124 988")
	    			//.field("first_name", "Marco Antonio")
	    			//.field("last_name", "Pereira")
	    			//.field("reply_markup", "ForceReply")
	                .asJson();
	    }
	     
	    public HttpResponse<JsonNode> getUpdates(Integer offset) throws UnirestException {
	        return Unirest.post(endpoint + "bot" + token + "/getUpdates")
	                .field("offset", offset)
	                .asJson();
	    }

	    public void run() throws UnirestException {
	        int last_update_id = 0; // controle das mensagens processadas
	        HttpResponse<JsonNode> response;
	        while (true) {
	        	System.out.println(sendMessageToMarco("Teste de push notification do bot... destino: MARCO PEREIRA").getBody());
	        	sendMessageToMarco("Teste de push notification do bot... destino: MARCO PEREIRA");
	        	
	        	response = getUpdates(last_update_id++);
	            if (response.getStatus() == 200) {
	                JSONArray responses = response.getBody().getObject().getJSONArray("result");
	                System.out.println(responses);
	                if (responses.isNull(0)) {
	                    continue;
	                } else {
	                    last_update_id = responses
	                            .getJSONObject(responses.length() - 1)
	                            .getInt("update_id") + 1;
	                }
	                
	                for (int i = 0; i < responses.length(); i++) {
	                    JSONObject message = responses
	                            .getJSONObject(i)
	                            .getJSONObject("message");
	                    int chat_id = message
	                            .getJSONObject("chat")
	                            .getInt("id");
	                    String usuario = message
	                            .getJSONObject("chat")
	                            //.getString("username"); //nao faz parte do node
	                            .getString("first_name"); //id do usuario no telegram 
	                    String texto = message
	                            .getString("text");
	                    String textoInvertido = "";

	                    for (int j = texto.length() - 1; j >= 0; j--) {
	                        textoInvertido += texto.charAt(j);
	                    }
	                    
	                    
	                    if(message.getString("text").trim().equalsIgnoreCase("/list")){
	                    	sendMessage(chat_id, "/list - List todos os comandos do BOT\n/produban - Histórico sobre a empresa");
	                    } else if(message.getString("text").trim().equalsIgnoreCase("/produban")){
	                    	sendMessage(chat_id, "A Produban é uma empresa de tecnologia do Grupo Santander, especializada em desenho e operação contínua de infraestruturas de TI, oferecendo um serviço completo aos seus clientes nas seguintes áreas:\n*Desenho e operação de centro de processamento de dados e suas interconexões.\n*Desenho e operação de infraestructura de TI com serviço.\n*Desenho e operação de plataforma de TI como serviço.\n*Processos de gestão e monitoração.\n*Gestão do risco tecnológico e continuidade de negócios.\n*Gestão de estações de trabalho, mobilidade e auto antendimento.");
	                    } else if(message.getString("text").trim().equalsIgnoreCase("/")){
	                    	sendMessage(chat_id, "Desculpe, não entendi sua mensagem!");
	                    }
	                    
	                    System.out.println();
	                    
	                    //sendMessage(chat_id, textoInvertido);
	                    
	                }	                
	            }
	        }
	    }
}
