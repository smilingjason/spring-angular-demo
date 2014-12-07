package demo.jason.springhello;

public abstract class Condition {
	
	public String name;
	
	//1 DataValue Condition; 2 System time condition
	public String flag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return flag;
	}
	
	
}
