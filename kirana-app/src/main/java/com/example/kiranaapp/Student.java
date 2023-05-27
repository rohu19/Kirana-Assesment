package com.example.kiranaapp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	private Integer id;
	private String name;
	private Integer age;
	private Integer totalMarks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Student(Integer id, String name, Integer age, Integer totalMarks) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.totalMarks = totalMarks;
	}

}
