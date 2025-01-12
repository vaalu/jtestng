/**
 * 
 */
package in.jeani.jtestng.automation.generics.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import in.jeani.jtestng.automation.generics.ITestStep;

/**
 * 
 */
public abstract class AbstractTestStep implements ITestStep {
	public static final Logger LOGGER = LoggerFactory.getLogger(AbstractTestStep.class);
	
	private String identifier;
	private String idType;
	private String action;
	private String value;
	
	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the idType
	 */
	public String getIdType() {
		return idType;
	}

	/**
	 * @param idType the idType to set
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("identifier : ").append(identifier);
		sb.append(" : idType : ").append(idType);
		sb.append(" : action : ").append(action);
		sb.append(" : value : ").append(value);
		return sb.toString();
	}
}
