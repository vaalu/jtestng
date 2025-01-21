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
	
	@Value("${com.icw.webdriver.wait.seconds}")
	private String webDriverWaitSeconds;
	
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
}
