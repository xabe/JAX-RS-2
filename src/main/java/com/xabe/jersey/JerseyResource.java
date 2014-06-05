package com.xabe.jersey;

import java.util.Locale;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Path("jersey-hello")
@Component
@Scope(value="request")
public class JerseyResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(JerseyResource.class.getName());
    private static final Locale LOCALE_SP = new Locale("ES");
    
    @Autowired
    private DateTimeService timeService;

    public JerseyResource() {
        LOGGER.info("HelloWorldResource()");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHello(@Context HttpHeaders headers) {
    	String result = "Upps!!";
    	Locale localeHeader;
    	
    	if(headers.getAcceptableLanguages().size() > 0)
    	{
    		localeHeader = headers.getAcceptableLanguages().get(0);
    		if(Locale.ENGLISH.equals(localeHeader))
	    	{
	    		result = String.format("%s: %s", timeService.getDateTime(), "Hello world");
	    	}
	    	else if(LOCALE_SP.equals(localeHeader))
	    	{
	    		result = String.format("%s: %s", timeService.getDateTime(), "Hola mundo");
	    	}
    	}
        return result;
    }

}
