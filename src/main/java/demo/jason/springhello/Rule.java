package demo.jason.springhello;

import java.util.ArrayList;
import java.util.List;

public class Rule {

	public String name;
	
	public List<Condition> conditions = new ArrayList<Condition>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
	
	
}
