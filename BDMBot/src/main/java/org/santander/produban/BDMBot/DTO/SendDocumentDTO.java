package org.santander.produban.BDMBot.DTO;

public class SendDocumentDTO {
	
	protected String chat_id;
	protected Object document;
	protected String caption;
	protected boolean disable_notification;
	protected Integer reply_to_message_id;
	protected String reply_markup;
	
	public String getChat_id() {
		return chat_id;
	}
	public void setChat_id(String chat_id) {
		this.chat_id = chat_id;
	}
	public Object getDocument() {
		return document;
	}
	public void setDocument(Object document) {
		this.document = document;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public boolean isDisable_notification() {
		return disable_notification;
	}
	public void setDisable_notification(boolean disable_notification) {
		this.disable_notification = disable_notification;
	}
	public Integer getReply_to_message_id() {
		return reply_to_message_id;
	}
	public void setReply_to_message_id(Integer reply_to_message_id) {
		this.reply_to_message_id = reply_to_message_id;
	}
	public String getReply_markup() {
		return reply_markup;
	} 
	public void setReply_markup(String reply_markup) {
		this.reply_markup = reply_markup;
	}

}
