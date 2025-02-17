/**
 * 
 */
package com.icw.automation.mobile.generics.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author mohanavelp
 *
 */
@Component
public class PropertiesUtil {

	@Value("${com.icw.auth.url}")
	private String authUrl;
	
	@Value("${com.icw.input.excel.file}")
	private String inputExcel;
	
	@Value("${com.icw.upload.docs.url}")
	private String uploadDocsUrl;
	
	@Value("${com.icw.mail.smtp.host}")
	private String smtpHost;
	
	@Value("${com.icw.mail.smtp.port}")
	private String smtpPort;
	
	@Value("${com.icw.mail.username}")
	private String username;
	
	@Value("${com.icw.mail.sendTo}")
	private String sendMailTo;
	
	@Value("${com.icw.mail.password}")
	private String password;
	
	@Value("${com.icw.driver.type}")
	private String driverType;
	
	@Value("${com.icw.android.platform}")
	private String androidPlatform;
	
	@Value("${com.icw.android.version}")
	private String androidVersion;
	
	@Value("${com.icw.android.device.name}")
	private String androidDeviceName;

	@Value("${com.icw.android.automation.name}")
	private String androidAutomationName;

	@Value("${com.icw.android.app.package}")
	private String androidAppPackage;

	@Value("${com.icw.android.app.activity}")
	private String androidActivity;

	@Value("${com.icw.android.url}")
	private String androidUrl;
	
	@Value("${com.icw.delete.loan.url}")
	private String deleteLoanUrl;
	
	@Value("${com.icw.delete.loan.payload}")
	private String deleteLoanPayload;
	
	@Value("${com.icw.webdriver.wait.seconds}")
	private String webDriverWaitSeconds;
	
	@Value("${com.icw.access.token.payload.ios}")
	private String accessTokenPayloadIOS;
	
	@Value("${com.icw.auth.login.url}")
	private String loginUrl;
	
	@Value("${com.icw.auth.login.payload}")
	private String loginPayload;
	
	/**
	 * @return the authUrl
	 */
	public String getAuthUrl() {
		return authUrl;
	}

	/**
	 * @param authUrl the authUrl to set
	 */
	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}

	/**
	 * @return the inputExcel
	 */
	public String getInputExcel() {
		return inputExcel;
	}

	/**
	 * @param inputExcel the inputExcel to set
	 */
	public void setInputExcel(String inputExcel) {
		this.inputExcel = inputExcel;
	}

	/**
	 * @return the driverType
	 */
	public String getDriverType() {
		return driverType;
	}

	/**
	 * @param driverType the driverType to set
	 */
	public void setDriverType(String driverType) {
		this.driverType = driverType;
	}

	/**
	 * @return the androidVersion
	 */
	public String getAndroidVersion() {
		return androidVersion;
	}

	/**
	 * @param androidVersion the androidVersion to set
	 */
	public void setAndroidVersion(String androidVersion) {
		this.androidVersion = androidVersion;
	}

	/**
	 * @return the androidDeviceName
	 */
	public String getAndroidDeviceName() {
		return androidDeviceName;
	}

	/**
	 * @param androidDeviceName the androidDeviceName to set
	 */
	public void setAndroidDeviceName(String androidDeviceName) {
		this.androidDeviceName = androidDeviceName;
	}

	/**
	 * @return the androidAutomationName
	 */
	public String getAndroidAutomationName() {
		return androidAutomationName;
	}

	/**
	 * @param androidAutomationName the androidAutomationName to set
	 */
	public void setAndroidAutomationName(String androidAutomationName) {
		this.androidAutomationName = androidAutomationName;
	}

	/**
	 * @return the androidAppPackage
	 */
	public String getAndroidAppPackage() {
		return androidAppPackage;
	}

	/**
	 * @param androidAppPackage the androidAppPackage to set
	 */
	public void setAndroidAppPackage(String androidAppPackage) {
		this.androidAppPackage = androidAppPackage;
	}

	/**
	 * @return the androidActivity
	 */
	public String getAndroidActivity() {
		return androidActivity;
	}

	/**
	 * @param androidActivity the androidActivity to set
	 */
	public void setAndroidActivity(String androidActivity) {
		this.androidActivity = androidActivity;
	}

	/**
	 * @return the androidUrl
	 */
	public String getAndroidUrl() {
		return androidUrl;
	}

	/**
	 * @param androidUrl the androidUrl to set
	 */
	public void setAndroidUrl(String androidUrl) {
		this.androidUrl = androidUrl;
	}

	/**
	 * @return the androidPlatform
	 */
	public String getAndroidPlatform() {
		return androidPlatform;
	}

	/**
	 * @param androidPlatform the androidPlatform to set
	 */
	public void setAndroidPlatform(String androidPlatform) {
		this.androidPlatform = androidPlatform;
	}

	/**
	 * @return the webDriverWaitSeconds
	 */
	public String getWebDriverWaitSeconds() {
		return webDriverWaitSeconds;
	}
	
	/**
	 * @return the webDriverWaitSeconds
	 */
	public int getWebDriverWaitInSeconds() {
		return Integer.parseInt(this.webDriverWaitSeconds);
	}

	/**
	 * @param webDriverWaitSeconds the webDriverWaitSeconds to set
	 */
	public void setWebDriverWaitSeconds(String webDriverWaitSeconds) {
		this.webDriverWaitSeconds = webDriverWaitSeconds;
	}

	/**
	 * @return the uploadDocsUrl
	 */
	public String getUploadDocsUrl() {
		return uploadDocsUrl;
	}

	/**
	 * @param uploadDocsUrl the uploadDocsUrl to set
	 */
	public void setUploadDocsUrl(String uploadDocsUrl) {
		this.uploadDocsUrl = uploadDocsUrl;
	}

	/**
	 * @return the deleteLoanUrl
	 */
	public String getDeleteLoanUrl() {
		return deleteLoanUrl;
	}

	/**
	 * @param deleteLoanUrl the deleteLoanUrl to set
	 */
	public void setDeleteLoanUrl(String deleteLoanUrl) {
		this.deleteLoanUrl = deleteLoanUrl;
	}

	/**
	 * @return the deleteLoanPayload
	 */
	public String getDeleteLoanPayload() {
		return deleteLoanPayload;
	}

	/**
	 * @param deleteLoanPayload the deleteLoanPayload to set
	 */
	public void setDeleteLoanPayload(String deleteLoanPayload) {
		this.deleteLoanPayload = deleteLoanPayload;
	}

	/**
	 * @return the accessTokenPayloadIOS
	 */
	public String getAccessTokenPayloadIOS() {
		return accessTokenPayloadIOS;
	}

	/**
	 * @param accessTokenPayloadIOS the accessTokenPayloadIOS to set
	 */
	public void setAccessTokenPayloadIOS(String accessTokenPayloadIOS) {
		this.accessTokenPayloadIOS = accessTokenPayloadIOS;
	}

	/**
	 * @return the loginUrl
	 */
	public String getLoginUrl() {
		return loginUrl;
	}

	/**
	 * @param loginUrl the loginUrl to set
	 */
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	/**
	 * @return the loginPayload
	 */
	public String getLoginPayload() {
		return loginPayload;
	}

	/**
	 * @param loginPayload the loginPayload to set
	 */
	public void setLoginPayload(String loginPayload) {
		this.loginPayload = loginPayload;
	}

	/**
	 * @return the mailHost
	 */
	public String getSmtpHost() {
		return smtpHost;
	}

	/**
	 * @param mailHost the mailHost to set
	 */
	public void setSmtpHost(String mailHost) {
		this.smtpHost = mailHost;
	}

	/**
	 * @return the mailPort
	 */
	public String getSmtpPort() {
		return smtpPort;
	}
	
	/**
	 * @return the mailPortNum
	 */
	public int getSmtpPortNumber() {
		return Integer.parseInt(this.getSmtpPort());
	}

	/**
	 * @param mailPort the mailPort to set
	 */
	public void setSmtpPort(String mailPort) {
		this.smtpPort = mailPort;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the sendMailTo
	 */
	public String getSendMailTo() {
		return sendMailTo;
	}
	
	public String[] getSentMailToRecipients() {
		return this.sendMailTo.split(",");
	}

	/**
	 * @param sendMailTo the sendMailTo to set
	 */
	public void setSendMailTo(String sendMailTo) {
		this.sendMailTo = sendMailTo;
	}
}
