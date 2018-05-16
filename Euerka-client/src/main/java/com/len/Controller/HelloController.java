package com.len.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private static final Logger log=LoggerFactory.getLogger(HelloController.class);
	@Autowired
	private DiscoveryClient client;
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello() {
		ServiceInstance localServiceInstance = client.getLocalServiceInstance();
		log.info("啦啦啦的不知道是什麼,{}",localServiceInstance.getServiceId());
		return "hello word";
	}
}
