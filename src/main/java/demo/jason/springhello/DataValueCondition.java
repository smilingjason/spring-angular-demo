package demo.jason.springhello;

public class DataValueCondition extends Condition {
	
	// > < = != etc;
	public String comparison;
	
	public String value;
	
	public DataValueCondition() {
		this.setFlag("1");
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getComparison() {
		return comparison;
	}

	public void setComparison(String comparison) {
		this.comparison = comparison;
	}
	
	
}
