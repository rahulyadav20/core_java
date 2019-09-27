package spring.exclude.autwiring;

import org.springframework.beans.factory.annotation.Autowired;

public class College {

	private Student student1;
	private String registration;
	private String year;

	@Autowired
	public void setStudent1(Student student) {
		this.student1 = student;
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
		return "College [registration=" + registration + ", Student="
				+ student1 + ",year=" + year + "]";
	}

}
