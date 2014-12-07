package demo.jason.springhello;

import java.beans.PropertyEditorSupport;

public class UserEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("Setting for USer with: " + text);
		super.setAsText(text);
	}

}
