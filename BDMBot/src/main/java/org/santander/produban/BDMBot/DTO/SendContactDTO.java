package org.santander.produban.BDMBot.DTO;

public class SendContactDTO {

	protected String chat_id;
	protected String phone_number;
	protected String first_name;
	protected String last_name;
	protected boolean disable_notification;
	protected Integer reply_to_message_id;
	protected String reply_markup;
	 
	public String getChat_id() {
		return chat_id;
	}
	public void setChat_id(String chat_id) {
		this.chat_id = chat_id;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
