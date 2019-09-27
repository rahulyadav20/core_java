package spring.bytype.autowiring.mode;

import org.springframework.beans.factory.annotation.Autowired;

public class College {
	
	private Student student2;
	private String registration;
	private String year;

	@Autowired
	public void setStudent2(Student student) {
		this.student2 = student;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "College [registration=" + registration + ", Student=" + student2 + 
                          ",year=" + year + "]";
	}

}
