package com.order.google.api;


import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstractApiClient<R,P> {

	@Autowired
	protected RequestErrorHandler handler;

	public abstract boolean isValid(P args);
	
	public abstract R get(P args);

}
