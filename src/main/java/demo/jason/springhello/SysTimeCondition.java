package demo.jason.springhello;

public class SysTimeCondition extends Condition {
	
	public String start;
	
	public String end;
	
	public SysTimeCondition() {
		this.setFlag("2");
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
	

}
