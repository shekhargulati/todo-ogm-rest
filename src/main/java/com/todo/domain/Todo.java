package com.todo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Todo {

	@Column(name="todo")
	private String todo;

	@Column(name="createdOn")
	private Date createdOn = new Date();

	public Todo() {
		// TODO Auto-generated constructor stub
	}

	public Todo(String todo) {
		this.todo = todo;
	}


	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Todo [todo=" + todo + ", createdOn=" + createdOn
				+ "]";
	}
	
}