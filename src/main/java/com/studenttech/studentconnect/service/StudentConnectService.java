package com.studenttech.studentconnect.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentconnect.generated.UserBasic;
import com.studentconnect.generated.UserDetails;

@RestController
@RequestMapping("/")
public class StudentConnectService {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello Student";
	}
	
	@RequestMapping(value="/postQuery", method={RequestMethod.GET,RequestMethod.POST})
	public String postQuery(@RequestParam String title, 
			@RequestParam String description,
			@RequestParam String[] category){
		return "SUCCESS "+Calendar.getInstance().getTime().toString();
	}
	
	@RequestMapping("/image")
	public String someMethod(@RequestParam long userid, 
			@RequestParam String token, 
			HttpServletResponse response) {
		
		return "yet to do";
	}
	
	
	@RequestMapping("/onlineUsers")
	public List<UserBasic> onlineUsers(@RequestParam long userid,
			@RequestParam long token) {
		List<UserBasic> users = new ArrayList<>();
		UserBasic user = new UserBasic();
		user.setName("Test user");
		user.setUserid(userid);
		user.setUsername("testuserid");
		users.add(user);
		return users;
	} 
	
	
	@RequestMapping("/categorySearch")
	public List<String> categorySearch(@RequestParam String searchString) {
		List<String> list = new ArrayList<>();
		list.add("SampleCategory1");
		list.add("SampleCategory2");
		list.add("SampleCategory3");
		return list;
	}
	
	@RequestMapping("/networkSearch")
	public List<UserDetails> networkSearch(@RequestParam String searchString, 
			@RequestParam(value="cat",required=false,defaultValue="0") int category) {
		List<UserDetails> list = new ArrayList<>();
		UserDetails user = new UserDetails();
		user.setName("Senthilkumar Annadurai");
		user.setUserid(123135645);
		user.setUsername("someid");
		user.setEducation("Anna university");
		user.setLocation("chennai");
		list.add(user);
		return list;
	}
	
}
