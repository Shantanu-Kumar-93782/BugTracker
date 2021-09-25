package com.BugTracker.util;

import javax.servlet.http.Cookie;

public class AuthorizedCookie{
	
	public static Cookie fetchAuthorizedCookie() {
		Cookie cookie = new Cookie("AuthToken", "Some random number");
		return cookie;
	}
}
