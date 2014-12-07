package demo.jason.springhello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RuleController {
	
	@ModelAttribute("system_params")
	public Map initParams() {
		Map< String, String > sysparams = new HashMap();
		sysparams.put("1", "Current Resource Value");
		sysparams.put("2", "System time");
		return sysparams;
	}
	
	@ModelAttribute("rule")
	
	public Rule createCondtion(HttpServletRequest request) {
		System.out.println("create one condition.");
		Rule rule = new Rule(); 
		DataBinder binder = new DataBinder(rule);
		
		binder.registerCustomEditor(Condition.class, new ConditionEditor());
		
		// create object from http request		
		Map<String, String> firstProps = new HashMap<String, String>();		
	    for (Object param : request.getParameterMap().keySet()){
	    	String paramStr = param.toString();
	        if (paramStr.indexOf(".") == -1){
	        	firstProps.put(paramStr, request.getParameter(paramStr));
	        	System.out.println("" + paramStr + " = " + request.getParameter(paramStr));
	        }
	    }
	    binder.bind(new MutablePropertyValues(firstProps));
	    
	    // hard code rule value for test only
	    /*
		rule.setName("Jason Huang");
		
		DataValueCondition dc = new DataValueCondition();
		dc.setComparison(">");
		dc.setValue("100");
		rule.getConditions().add(dc);
		
		SysTimeCondition sc = new SysTimeCondition();
		sc.setStart("09:00");
		sc.setEnd("18:00");
		rule.getConditions().add(sc);
		*/
	    
		return rule;
	}
	
	@RequestMapping(value = "/rule/create", method = RequestMethod.GET)
	public String createRule(
			@ModelAttribute("rule") Rule rule,
			BindingResult bindingResult,
			Model Model,
			HttpServletRequest request) {
		System.out.println("createRule = " + rule.getName());
		
		return "rule";
	}
	
	@RequestMapping(value = "/rule/save", method = RequestMethod.POST)
	public String saveCondtion(@ModelAttribute Rule rule) {
		System.out.println("saveRule = " + rule.getName());
		//remove invalid conditions
		List<Condition> list = new ArrayList<Condition>();
		for(int i = 0; i < rule.getConditions().size(); i++) {
			Condition condition = rule.getConditions().get(i);
			if (!condition.getFlag().trim().equals("")) {
				list.add(condition);
			}
		}
		rule.setConditions(list);
		return "rule";
	}
}
