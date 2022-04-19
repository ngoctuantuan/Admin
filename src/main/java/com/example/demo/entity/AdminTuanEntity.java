package com.example.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
public class AdminTuanEntity {
	 
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		private String username;
		private String pwd;
		private String email;
		private int phone;

	


}
