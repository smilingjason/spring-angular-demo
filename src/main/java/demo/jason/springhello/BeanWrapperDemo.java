package demo.jason.springhello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BeanWrapperDemo {

	public static void main(String[] args) {
		BeanWrapperImpl wrapper = new BeanWrapperImpl();
		User temp = new User();
		wrapper.setAutoGrowNestedPaths(true);
		wrapper.setWrappedInstance(temp);
		wrapper.setPropertyValue("name", "Jason");
		
		AddressEmail address = new AddressEmail();
		address.setFlag(0);
		address.setLocation("Foobar");
		address.setPostcode("100000");
		wrapper.setPropertyValue("address.location", "huang");
		
		List<Address> list = new ArrayList<Address>();
		list.add(address);
		wrapper.setPropertyValue("addresses", list);
		
		wrapper.setPropertyValue("addresses[1].location", "abc");
		wrapper.setPropertyValue("addresses[1].postcode", "110");
		
		User user = (User) wrapper.getWrappedInstance();
		System.out.println(user.getName());
		//System.out.println(user.getAddress().getLocation());
		System.out.println(user.getAddresses().size());
		System.out.println(user.getAddresses().get(0).getLocation());
	}

}
