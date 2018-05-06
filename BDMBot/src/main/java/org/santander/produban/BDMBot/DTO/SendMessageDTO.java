package org.santander.produban.BDMBot.DTO;

import org.springframework.beans.factory.annotation.Required;

import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * @author Marco Antonio Pereira
 * @version 0.0.1
 * @since 08 de Setembro de 2016
 *  
 *  Objeto para obter e enviar mensagem para a API do Telegram
 */
public class SendMessageDTO {
	
	protected String chat_id;
	protected String text;
	protected String parse_mode;
	protected boolean disable_web_page_preview;
	protected boolean disable_notification;
	protected Integer reply_to_message_id;
	protected String reply_markup;
	 
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	
	/**
	 * @return the chat_id
	 */
	public String getChat_id() {
		return chat_id;
	}
	
	/**
	 * @param chat_id the chat_id to set
	 */
	@Required
	public void setChat_id(String chat_id) {
		this.chat_id = chat_id;
	}
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * @param text the text to set
	 */
	@Required
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * @return the parse_mode
	 */
	public String getParse_mode() {
		return parse_mode;
	}
	
	/**
	 * @param parse_mode the parse_mode to set
	 */
	public void setParse_mode(String parse_mode) {
		this.parse_mode = parse_mode;
	}
	
	/**
	 * @return the disable_web_page_preview
	 */
	public boolean isDisable_web_page_preview() {
		return disable_web_page_preview;
	}
	
	/**
	 * @param disable_web_page_preview the disable_web_page_preview to set
	 */
	public void setDisable_web_page_preview(boolean disable_web_page_preview) {
		this.disable_web_page_preview = disable_web_page_preview;
	}
	
	/**
	 * @return the disable_notification
	 */
	public boolean isDisable_notification() {
		return disable_notification;
	}
	
	/**
	 * @param disable_notification the disable_notification to set
	 */
	public void setDisable_notification(boolean disable_notification) {
		this.disable_notification = disable_notification;
	}
	
	/**
	 * @return the reply_to_message_id
	 */
	public Integer getReply_to_message_id() {
		return reply_to_message_id;
	}
	
	/**
	 * @param reply_to_message_id the reply_to_message_id to set
	 */
	public void setReply_to_message_id(Integer reply_to_message_id) {
		this.reply_to_message_id = reply_to_message_id;
	}
	
	/**
	 * @return the reply_markup
	 */
	public String getReply_markup() {
		return reply_markup;
	}
	
	/**
	 * @param reply_markup the reply_markup to set
	 */
	public void setReply_markup(String reply_markup) {
		this.reply_markup = reply_markup;
	}
	
}
