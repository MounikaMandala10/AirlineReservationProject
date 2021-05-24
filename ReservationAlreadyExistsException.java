package com.example.demo.layer4.exceptions;

@SuppressWarnings("serial")
public class ReservationAlreadyExistsException extends Exception {
	public  ReservationAlreadyExistsException(String msg)
	{
		super(msg);
	}
}
