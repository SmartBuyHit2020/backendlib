package com.hit.sb.controller;

import javax.servlet.http.HttpSession;

public class BaseController {
	/**
	 * 从Session获取当前登录的用户id
	 * @param session HttpSession对象
	 * @return 当前登录的用户id
	 */
	protected final int getUidFromSession(HttpSession session) {
		return Integer.valueOf(session.getAttribute("uid").toString());
	}

}
