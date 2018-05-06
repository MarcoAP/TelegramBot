package org.santander.produban.BDMBot.DTO;

public class SendVideoDTO {
	
	protected String chat_id;
	protected Object video;
	protected Integer duration;
	protected Integer width;
	protected Integer height;
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
	public Object getVideo() {
		return video;
	}
	public void setVideo(Object video) {
		this.video = video;
	} 
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
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
