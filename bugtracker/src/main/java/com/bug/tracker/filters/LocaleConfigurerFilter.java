package com.bug.tracker.filters;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.LocaleResolver;

public class LocaleConfigurerFilter extends OncePerRequestFilter {

	private LocaleResolver localeResolver;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
		if (localeResolver!=null) {
            Locale locale = localeResolver.resolveLocale(request);
            LocaleContextHolder.setLocale(locale);
        }
		
		chain.doFilter(request, response);

        if (localeResolver!=null) {
            LocaleContextHolder.resetLocaleContext();
        }
	}

}
