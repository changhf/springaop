package com.changhf;

import com.changhf.spring.UserManager;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * xml配置和注解方式，具体选择哪种看实际情况。要想工作量小，开发效率高就用注解方式，要想更易于扩展就选择配置方式。
 * 
 * @author changhf
 *
 */
public class Client {

	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserManager userManager = (UserManager) factory.getBean("userManager");
		userManager.delUser(1);
	}
}
