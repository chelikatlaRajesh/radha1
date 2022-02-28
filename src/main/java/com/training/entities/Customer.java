package com.training.entities;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Document("customers1")
@Data
public class Customer {

	@Id
	private long customerId;
	private String name;
	private String email;
	private double balance;
}
