/**
 * 
 */
package com.icw.automation.mobile.generics.util;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
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
	
	public void deleteLoan(String accessToken) {
		
		String deleteLoanUrl = props.getDeleteLoanUrl();
		String deletePayload = props.getDeleteLoanPayload();
		
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpDelete postReq = new HttpDelete(deleteLoanUrl);
			postReq.setEntity(new StringEntity(deletePayload));
			postReq.setHeader("Content-Type", "application/json");
			postReq.setHeader("Content-Type", "Bearer " + accessToken);
			
			try (CloseableHttpResponse response = client.execute(postReq)) {
				LOGGER.info("File upload status: {}",response.getCode());
				String responseBody = EntityUtils.toString(response.getEntity());
				LOGGER.info("File upload response: {}", responseBody);
				if (response.getCode() == 200 || response.getCode() == 204) {
					LOGGER.info("Loan deleted successfully: {}", responseBody);
				} else {
					LOGGER.error("Unable to delete loan. {}", responseBody);
				}
			} catch (ParseException e) {
				LOGGER.error("Error occurred while deleting loan.", e);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeApp() {
		
	}
	public void openApp() {
		
	}
	
}
