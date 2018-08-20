package org.marketing.hikefactory.model;

public class NewHikes {
	
	private String subject;
	private String content;
	
	public NewHikes() {
		
	}
	public NewHikes(String subject, String content) {
		this.subject = subject;
		this.content = content;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "NewHikes [subject=" + subject + ", content=" + content + "]";
	}
	
	

}
