package spring.constructor.autowiring.mode;

public class Student {
	private String age;
	private String name;
	private String address;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + 
                          ",address=" + address + "]";
	}

}
