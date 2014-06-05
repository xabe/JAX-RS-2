package com.xabe.jersey.test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Assert;
import org.junit.Test;

import com.xabe.jersey.MyApplication;

public class HelloTest extends JerseyTest {

	  @Override
	  protected Application configure() {
	    enable(TestProperties.LOG_TRAFFIC);
	    enable(TestProperties.DUMP_ENTITY);
	    return new MyApplication();
	  }


	  @Test
	  public void Test() {
		  Response response = target("jersey-hello.json").request().get();
		  String value = response.readEntity(String.class).toString();
		  Assert.assertEquals("Upps!!",value);
	  }
	  
	  @Test
	  public void spanishTest() {
		  Response response = target("jersey-hello.spanish").request().get();
		  String value = response.readEntity(String.class).toString();
		  Assert.assertNotEquals("Upps!!",value);
	  }
	  
	  @Test
	  public void englishTest() {
		  Response response = target("jersey-hello.english").request().get();
		  String value = response.readEntity(String.class).toString();
		  Assert.assertNotEquals("Upps!!",value);
	  }
	}
