package com.fdmgroup.springmvcwalkthrough;

public class PasswordValidator {

	public boolean check(String pass1, String pass2) {
		if (pass1.equals(pass2)) {
			return true;
		}
		return false;
	}
}