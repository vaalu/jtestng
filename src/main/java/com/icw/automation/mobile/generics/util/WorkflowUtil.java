/**
 * 
 */
package com.icw.automation.mobile.generics.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
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
	
	public static final String HTML_REPORT_FILE_PATH = "reports/test_results.html";
	
	@Autowired
	PropertiesUtil propsUtil;
	
	public String getAccessToken() {
		String authUrl = propsUtil.getAuthUrl();
		String accessToken = "";
		LOGGER.debug("Fetching access token from url: {}", authUrl);
		String deletePayload = propsUtil.getAccessTokenPayloadIOS();
		
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpPost postReq = new HttpPost(authUrl);
			postReq.setEntity(new StringEntity(deletePayload));
			postReq.setHeader("Content-Type", "application/json");
			
			try (CloseableHttpResponse response = client.execute(postReq)) {
				LOGGER.info("File upload status: {}",response.getCode());
				String responseBody = EntityUtils.toString(response.getEntity());
				LOGGER.info("File upload response: {}", responseBody);
				if (response.getCode() == 200 || response.getCode() == 204) {
					LOGGER.info("Loan deleted successfully: {}", responseBody);
					accessToken = responseBody.substring(responseBody.indexOf("accessToken\":\"") + 14, 
							responseBody.indexOf("\"", responseBody.indexOf("accessToken\":\"") + 14));
				} else {
					LOGGER.error("Unable to delete loan. {}", responseBody);
				}
			} catch (ParseException e) {
				LOGGER.error("Error occurred while deleting loan.", e);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accessToken;
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
		
		String deleteLoanUrl = propsUtil.getDeleteLoanUrl();
		String deletePayload = propsUtil.getDeleteLoanPayload();
		
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpDelete postReq = new HttpDelete(deleteLoanUrl);
			postReq.setEntity(new StringEntity(deletePayload));
			postReq.setHeader("Content-Type", "application/json");
			postReq.setHeader("Authorization", "Bearer " + accessToken);
			
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
	
	public String login(String email, String accessToken) {
		// ***@***.*** to be replaced with passed email address
		String loginPayload = propsUtil.getLoginPayload();
		loginPayload = loginPayload.replace("***@***.***", email);
		
		String authUrl = propsUtil.getLoginUrl();
		String userToken = "";
		LOGGER.debug("Fetching access token from url: {} with payload {}", authUrl, loginPayload);
		String deletePayload = propsUtil.getAccessTokenPayloadIOS();
		
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpPost postReq = new HttpPost(authUrl);
			postReq.setEntity(new StringEntity(deletePayload));
			postReq.setHeader("Content-Type", "application/json");
			postReq.setHeader("Authorization", "Bearer " + accessToken);
			
			try (CloseableHttpResponse response = client.execute(postReq)) {
				LOGGER.info("File upload status: {}",response.getCode());
				String responseBody = EntityUtils.toString(response.getEntity());
				LOGGER.info("File upload response: {}", responseBody);
				if (response.getCode() == 200 || response.getCode() == 204) {
					LOGGER.info("Loan deleted successfully: {}", responseBody);
					accessToken = responseBody.substring(responseBody.indexOf("accessToken\":\"") + 14, 
							responseBody.indexOf("\"", responseBody.indexOf("accessToken\":\"") + 14));
				} else {
					LOGGER.error("Unable to delete loan. {}", responseBody);
				}
			} catch (ParseException e) {
				LOGGER.error("Error occurred while deleting loan.", e);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userToken;
	}
	public String getEmailContents() throws IOException {
		String htmlContent = "";
		
		BufferedReader br = new BufferedReader(new FileReader(HTML_REPORT_FILE_PATH));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    htmlContent = sb.toString();
		} finally {
		    br.close();
		}
		
		return htmlContent;
	}
	public void sendEmail() throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.host", this.propsUtil.getSmtpHost());
		props.put("mail.smtp.port", this.propsUtil.getSmtpPort());
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", this.propsUtil.getSmtpPort());
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    
		Session session = Session.getInstance(props, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(propsUtil.getUsername(), propsUtil.getPassword());
		    }
		});
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("mohu_mca@yahoo.co.in"));
		message.setRecipients(
		  Message.RecipientType.TO, InternetAddress.parse(propsUtil.getSendMailTo()));
		message.setSubject("Testing results");

		String msg = this.getEmailContents();
		
		Multipart mp = new MimeMultipart();
		MimeBodyPart htmlPart = new MimeBodyPart();
		htmlPart.setContent(msg, "text/html");
		mp.addBodyPart(htmlPart);
		message.setContent(mp);

		Transport.send(message);
	}
}
