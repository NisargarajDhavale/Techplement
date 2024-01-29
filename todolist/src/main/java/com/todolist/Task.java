package com.todolist;

import javax.persistence.*;
import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Table(name = "tasks")
public class Task {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
@Column(length = 1500)
 private String description;
 private boolean completed;

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Task(String Description, boolean completed) {
		super();
		this.id = new Random().nextInt(1000);
		this.description = description;
		this.completed = completed;
	}

	
 public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public boolean isCompleted() {
	return completed;
}
public void setCompleted(boolean completed) {
	this.completed = completed;
}

}