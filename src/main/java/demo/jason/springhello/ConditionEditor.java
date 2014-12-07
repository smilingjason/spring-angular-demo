package demo.jason.springhello;

import java.beans.PropertyEditorSupport;

public class ConditionEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("setAsText Condition object with: " + text);
		Object newValue = null;
		if ("1".equals(text))
			newValue = new DataValueCondition();
		else if("2".equals(text))
			newValue = new SysTimeCondition();
		else 
			newValue = new DefaultCondition();
		
		System.out.println(newValue);
		setValue(newValue);
	}
}
