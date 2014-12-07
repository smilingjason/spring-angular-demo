package demo.jason.springhello;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.DataBinder;

public class DataBindDemo {

	public static void main(String[] args) {
		User user = new User();
		DataBinder binder = new DataBinder(user);
		//binder.setAutoGrowNestedPaths(false);
		binder.registerCustomEditor(Address.class, new AddressEditor());
		Map<String, String> props = new HashMap<String, String>();
		props.put("name", "Jason Huang");
		props.put("address", "demo.jason.springhello.AddressEmail");
		props.put("addresses[0]", "demo.jason.springhello.AddressEmail");
		binder.bind(new MutablePropertyValues(props));
		
		props = new HashMap<String, String>();
		/*props.put("name", "Jason Huang");
		props.put("address", "demo.jason.springhello.AddressEmail");*/
		props.put("address.location", "Beijing");
		props.put("address.postcode", "100100");
		props.put("addresses[0].location", "Beijing2");
		props.put("addresses[0].postcode", "100000");
		binder.bind(new MutablePropertyValues(props));
		
		
		System.out.println(user.getName());
		
		System.out.println(user.getAddress().getLocation());
		System.out.println(user.getAddress().getPostcode());
		
		System.out.println(user.getAddresses().size());
		
		System.out.println(user.getAddresses().get(0).getClass());

	}

}
