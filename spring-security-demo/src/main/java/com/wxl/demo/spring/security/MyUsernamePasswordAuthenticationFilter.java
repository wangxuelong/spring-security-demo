package com.wxl.demo.spring.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * 进行登录验证
 * 
 * @author 王学龙
 * @date 2014年11月28日 下午4:05:52
 */
public class MyUsernamePasswordAuthenticationFilter extends
		UsernamePasswordAuthenticationFilter {

	public MyUsernamePasswordAuthenticationFilter() {
		this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(
				"/login"));
		this.setUsernameParameter("userId");
		this.setPasswordParameter("password");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		if (request.getMethod().toUpperCase().equals("POST")) {
			String userId = obtainUsername(request);
			String password = obtainPassword(request);
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
					userId, password);

			setDetails(request, token);
			// 根据用户和密码查询
			return getAuthenticationManager().authenticate(token);
		} else {
			throw new AuthenticationServiceException(
					"Authentication method not supported: "
							+ request.getMethod());
		}
	}

}
