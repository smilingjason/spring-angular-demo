package demo.jason.springhello;

import java.util.List;

public interface Rule {

	public String getName();

	public void setName(String name);

	public List<Condition> getConditions();

	public void setConditions(List<Condition> conditions);
	
	
}
