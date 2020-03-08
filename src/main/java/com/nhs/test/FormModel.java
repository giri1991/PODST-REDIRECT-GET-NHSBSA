package com.nhs.test;

import javax.validation.constraints.Size;

public class FormModel {
	@Size(max=10)
	String value;
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
