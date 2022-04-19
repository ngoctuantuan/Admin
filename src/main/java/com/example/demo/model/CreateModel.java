package com.example.demo.model;

import javax.persistence.GeneratedValue;


import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class CreateModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String username;
	private String pwd;
	private String email;
	private long phone;

}
