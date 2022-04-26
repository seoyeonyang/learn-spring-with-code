package org.zerok.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AccessControlInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		Object loginId = session.getAttribute("loginId");

		if (loginId == null) {

			response.sendRedirect("/");
			return false;
		}

		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
