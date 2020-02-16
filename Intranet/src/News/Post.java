package News;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;

import User.User;

public class Post implements Serializable{
	private String title;
	private String text;
	private User author;
	private Date publishedDate;
	public Post(String title, String text, User author, Date date) {
		this.author = author;
		this.text = text;
		this.title = title;
		this.publishedDate = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String toString() {
		return this.getTitle()+'\n'+this.getText()+'\n'+this.getAuthor().toString() + " " + this.getPublishedDate().toString();
	}
	
}
