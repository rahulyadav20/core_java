package spring.autodetect.autowiring.mode;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireMain {
	public static void main(String[] args) {
		BeanFactory beanfactory = new ClassPathXmlApplicationContext(
				"context.xml");
		College coll = (College) beanfactory.getBean("college4");
		System.out.println(coll);
	}
}