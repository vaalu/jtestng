/**
 * 
 */
package com.icw.automation.mobile.generics.util;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
public class WorkflowUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(WorkflowUtil.class);
	@Autowired
	PropertiesUtil props;
	
	public String getAccessToken() {
		String authUrl = props.getAuthUrl();
		LOGGER.debug("Fetching access token from url: {}", authUrl);
		return null;
	}
	
	public String generateRandomEmail() {
		String alphaNumChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sbEmail = new StringBuilder();
        Random rnd = new Random();
        while (sbEmail.length() < 10) { 
            int index = (int) (rnd.nextFloat() * alphaNumChars.length());
            sbEmail.append(alphaNumChars.charAt(index));
        }
        sbEmail.append("@yopmail.com");
        return sbEmail.toString();
	}
	
	public void closeApp() {
		
	}
	public void openApp() {
		
	}
	
}
