package com.spring.boot.app.config;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import com.spring.boot.app.view.ExcelView;


public class ExcelViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
       ExcelView view = new ExcelView();
        return view;
    }
}
