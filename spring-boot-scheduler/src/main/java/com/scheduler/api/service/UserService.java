package com.scheduler.api.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.scheduler.api.dao.UserDao;
import com.scheduler.api.model.User;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	Logger log = LoggerFactory.getLogger(UserService.class);

	// schedule a job to add object in DB (Every 5 sec)
	@Scheduled(fixedRate = 5000)
	public void add2DBJob() {
		User user = new User();
		user.setName("user" + new Random().nextInt(374483));
		dao.save(user);
		System.out.println("add service call in " + new Date().toString());
	}

	@Scheduled(cron = "0/15 * * * * *")
	public void fetchDBJob() {
		List<User> user = dao.findAll();
		System.out.println("Fetch service call in " + new Date().toString());
		System.out.println("No of record fetched: " + user.size());
		log.info("users : {}", user);
	}
}
