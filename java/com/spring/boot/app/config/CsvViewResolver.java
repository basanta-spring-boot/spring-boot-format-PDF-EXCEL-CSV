package com.spring.boot.app.config;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import com.spring.boot.app.view.CsvView;

public class CsvViewResolver implements ViewResolver {
	@Override
	public View resolveViewName(String s, Locale locale) throws Exception {
		CsvView view = new CsvView();
		return view;
	}
}
