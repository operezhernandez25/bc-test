package com.diomedes.bcsecurity.config;

import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

@Configuration
public class LocaleConfig {

    @PostConstruct
    public void init() {

        TimeZone.setDefault(TimeZone.getTimeZone("America/El_Salvador"));

        System.out.println("Date in America/El_Salvador   : " + new Date().toString());
    }
}