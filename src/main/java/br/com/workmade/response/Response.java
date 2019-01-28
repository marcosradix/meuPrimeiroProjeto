package br.com.workmade.response;

import java.util.HashMap;
import java.util.Map;

public class Response<T> {

	private T data;
	private Map<String, String> errors;

	public Response() {
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Map<String, String> getErrors() {
		if (this.errors == null) {
			this.errors = new HashMap<String, String>();
		}
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

}
