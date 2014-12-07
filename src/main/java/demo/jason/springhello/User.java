package demo.jason.springhello;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

public class User {
	
	@NotNull
	private String name;
	
	private Address address;
	
	private List<Address> addresses = new ArrayList<Address>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
