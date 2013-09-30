package example.elasticsearch.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable {
	private String code; //in the form EMP-1234
	private String firstName;
	private String lastName;
	private Long dateOfBirth; //in times in millis
	private String ssn;
	private Address homeAddress;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Long dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
}
