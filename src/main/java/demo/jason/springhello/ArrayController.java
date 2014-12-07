package demo.jason.springhello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller

public class ArrayController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/array", method = RequestMethod.POST)
	public String home(Model model, HttpServletRequest request) {
		User user = getUser(request);
		//remove null elements
		List<Address> list = new ArrayList<Address>();
		for(int i = 0; i < user.getAddresses().size(); i++) {
			Address address = user.getAddresses().get(i);
			if (address.getLocation() != null && !address.getLocation().trim().equals("")) {
				list.add(address);
			}
		}
		user.setAddresses(list);
		model.addAttribute("user", user);
		return "array";
	}
	
	@RequestMapping(value = "/findarray", method = RequestMethod.GET)
	public String newArray(Model model) {
		User user = new User();
		user.setName("Jason");
		
		Address a = new AddressMobile();
		a.setLocation("Default");
		a.setPostcode("102208");
		a.setFlag(0);
		user.setAddress(a);
		
		a = new AddressMobile();
		a.setLocation("HLG");
		a.setPostcode("102208");
		a.setFlag(0);
		((AddressMobile) a).setMobile("12345678");
		user.getAddresses().add(a);
		a = new AddressEmail();
		a.setFlag(1);
		a.setLocation("GTC");
		a.setPostcode("100000");
		((AddressEmail) a).setEmail("12345678@intel.com");
		user.getAddresses().add(a);

		model.addAttribute("user", user);
		return "array";
	}
	
	
	
	public User getUser(HttpServletRequest request) {
		
		User user = new User();
		DataBinder binder = new DataBinder(user);
		binder.setValidator(new UserValidator());
		binder.registerCustomEditor(Address.class, new AddressEditor());
		
		// create object from http request
		System.out.println("address = " + request.getParameter("address"));
		Map<String, String> firstProps = new HashMap<String, String>();
		
	    for (Object param : request.getParameterMap().keySet()){
	    	String paramStr = param.toString();
	        if (paramStr.indexOf(".") == -1){
	        	firstProps.put(paramStr, request.getParameter(paramStr));
	        	System.out.println("" + paramStr + " = " + request.getParameter(paramStr));
	        }
	    }
	    binder.bind(new MutablePropertyValues(firstProps));
	    Map<String, String> secondProps = new HashMap<String, String>();
	    for (Object param : request.getParameterMap().keySet()){
	    	String paramStr = param.toString();
	        if (paramStr.indexOf(".") > -1){
	        	secondProps.put(paramStr,  request.getParameter(paramStr));
	        	System.out.println("" + paramStr + " = " + request.getParameter(paramStr));
	        }
	    }
	    binder.bind(new MutablePropertyValues(secondProps));
	    binder.validate();
	    BindingResult bindingResult = binder.getBindingResult();
	    System.out.println("Error count: = " + bindingResult.getErrorCount());
		return user;		
	}
	
	public User getHardcodedUser(HttpServletRequest request) {
		User user = new User();
		DataBinder binder = new DataBinder(user);
		binder.registerCustomEditor(Address.class, new AddressEditor());
		
		// hard code object
		Map<String, String> props = new HashMap<String, String>();
		props.put("name", "Jason Huang");
		
		props.put("address", "demo.jason.springhello.AddressEmail");
		props.put("addresses[0]", "demo.jason.springhello.AddressEmail");
		binder.bind(new MutablePropertyValues(props));
		
		props = new HashMap<String, String>();		
		props.put("address.location", "Beijing");
		props.put("address.postcode", "100100");
		props.put("addresses[0].location", "Beijing2");
		props.put("addresses[0].postcode", "100000");
		props.put("addresses[0].email", "aaa@intel.com");
		binder.bind(new MutablePropertyValues(props));
		
		return user;		
	}
}
