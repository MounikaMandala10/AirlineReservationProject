package com.example.demo.layer4.exceptions;

@SuppressWarnings("serial")
public class AdminAlreadyExistsException extends Exception {
	public AdminAlreadyExistsException(String msg) {
		super(msg);
	}
}
