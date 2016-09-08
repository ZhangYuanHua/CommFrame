package com.github.anzewei.parallaxbacklayout;

public class HmmEvent {
	private String message;
	public static int MSG_UPDATE = 1;

	public HmmEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HmmEvent(String message) {
		super();
		this.message = message;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
