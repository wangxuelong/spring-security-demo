package com.wxl.demo.spring.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.util.UrlPathHelper;

/**
 * 此类在初始化时，应该取到所有资源及其对应角色的定义
 * 
 * @author 王学龙
 * @date 2014年11月28日 上午11:18:24
 */
public class MyInvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {
	UrlPathHelper helper = new UrlPathHelper();

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	public MyInvocationSecurityMetadataSource() {
		loadResourceDefine();

	}

	private void loadResourceDefine() {
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		Collection<ConfigAttribute> attrs = new ArrayList<ConfigAttribute>();
		attrs.add(new SecurityConfig("ROLE_USER"));

		resourceMap.put("/index.jsp", attrs);
		resourceMap.put("/other.jsp", attrs);

		Collection<ConfigAttribute> adminAttrs = new ArrayList<ConfigAttribute>();
		adminAttrs.add(new SecurityConfig("ROLE_ADMIN"));
		resourceMap.put("/admin.jsp", adminAttrs);
	}

	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		FilterInvocation fi = (FilterInvocation) object;
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resUrl = ite.next();
			RequestMatcher requestMatcher = new AntPathRequestMatcher(resUrl);
			if (requestMatcher.matches(fi.getHttpRequest())) {
				return resourceMap.get(resUrl);
			}
		}
		return null;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}
}
