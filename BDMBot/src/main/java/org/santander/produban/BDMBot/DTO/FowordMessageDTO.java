package org.santander.produban.BDMBot.DTO;

public class FowordMessageDTO {
	
	protected String chat_id;
	protected String from_chat_id;
	protected boolean disable_notification;
	protected Integer message_id;
	 
	public String getChat_id() {
		return chat_id;
	}
	public void setChat_id(String chat_id) {
		this.chat_id = chat_id;
	}
	public String getFrom_chat_id() {
		return from_chat_id;
	}
	public void setFrom_chat_id(String from_chat_id) {
		this.from_chat_id = from_chat_id;
	}
	public boolean isDisable_notification() {
		return disable_notification;
	}
	public void setDisable_notification(boolean disable_notification) {
		this.disable_notification = disable_notification;
	}
	public Integer getMessage_id() {
		return message_id;
	}
	public void setMessage_id(Integer message_id) {
		this.message_id = message_id;
	}
	
}
