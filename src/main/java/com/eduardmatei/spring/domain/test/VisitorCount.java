package com.eduardmatei.spring.domain.test;

import java.io.Serializable;

public class VisitorCount implements Serializable {
	
	private static final long serialVersionUID = 9213877421950L;
	
	private int count;

	public VisitorCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
