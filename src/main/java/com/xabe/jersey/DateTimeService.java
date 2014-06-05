package com.xabe.jersey;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="dateTimeService")
@Scope(value="request")
public class DateTimeService {

	public Date getDateTime() {
        return new Date();
    }
}
