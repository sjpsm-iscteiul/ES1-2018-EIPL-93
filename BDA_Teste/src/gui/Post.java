package gui;

import java.time.LocalDate;
import java.time.LocalTime;

public class Post {
	
	private LocalDate date;
	private LocalTime time;
	private String message;
	private String author;
	private Channel channel;
	
	
	
	public String getMessage() {
		return message;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public Channel getChannel() {
		return channel;
	}
	
	public String getPreview() {
		return message.substring(0, 250);
	}
	
	
	
	
	
	
}

