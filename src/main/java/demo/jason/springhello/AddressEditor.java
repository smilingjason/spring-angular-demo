package demo.jason.springhello;

import java.beans.PropertyEditorSupport;

public class AddressEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("setAsText address object with: " + text);
		String clazzName = text.toString();
		Object newValue = null;
		try {
			newValue = Class.forName(clazzName).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(newValue);
		setValue(newValue);
	}

	@Override
	public void setValue(Object value) {
		System.out.println("setValue called Create address object with: " + value);
		
		super.setValue(value);
	}

	
}
