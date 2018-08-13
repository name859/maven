package com.name859.service.maven.user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.name859.domain.maven.user.User;
import com.name859.util.Number;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
public class UserServiceTest {

	@Autowired private UserService service;
	
	private Number number = new Number();
	
	private User makeUser() {
		int rn = number.getRandomNumber(100, 999);
		
		User user = new User();
		user.setName("name"+ rn);
		user.setPassword(Integer.toString(rn));
		user.setMail(user.getName() +"@naver.com");
		user.setPhone(number.makePhoneNumber(rn));
		user.setPhoto(user.getName() +".jpg");
		user.setVital("N");
		
		return user;
	}
	
	@Test
	public void userIO() throws Exception {
		for (int i = 0; i < 20; i++) {
			User user = makeUser();
			System.out.println("@@@ Before Save Add User : "+ user.toString());
			
			user = service.add(user);
			System.out.println("@@@ After Save Add userId : "+ user.getUserId());
			
			user = service.findById(user.getUserId());
			System.out.println("@@@ After Save Add User : "+ user.toString());
			
			user.setVital("Y");
			System.out.println("@@@ Before Save Modify User : "+ user.toString());
			
			user = service.modify(user);
			System.out.println("@@@ After Save Modify userId : "+ user.getUserId());
			
			user = service.findById(user.getUserId());
			System.out.println("@@@ After Save Modify User : "+ user.toString());
		}
		
		List<User> list = service.findAll();
		System.out.println("@@@ User List Size : "+ list.size());
		
		for (User user : list) {
			System.out.println("@@@ User List ["+ list.indexOf(user) +"] : "+ user.toString());
		}
	}
	
}
