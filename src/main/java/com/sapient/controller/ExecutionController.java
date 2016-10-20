package com.sapient.controller;

import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import org.apache.activemq.broker.BrokerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.config.AppConfig;
import com.sapient.jms.ActiveMQControl;
import com.sapient.main.Login;
import com.sapient.model.User;
import com.sapient.service.BrokerService;
import com.sapient.service.BrokerServiceImpl;
import com.sapient.service.UserService;

@Service("execution")
@Controller
public class ExecutionController implements Runnable {

	HttpServletRequest req;

	@Override
	public void run() {
		String start = req.getParameter("start");
		System.out.println("username: " + start);

		// ActiveMQControl bro = ActiveMQControl.getInstance();
		// bro.startBroker();

		AbstractApplicationContext container = new AnnotationConfigApplicationContext(
				com.sapient.config.AppConfig.class);
		container.registerShutdownHook();

		BrokerService brokerService = (BrokerService) container.getBean("brokerService");

		brokerService.StartExecution();
		brokerService.StartExecution();
		brokerService.StartExecution();

	}

	@RequestMapping("/views/startStopService")
	public String startThreadExecution(HttpServletRequest req) throws URISyntaxException, Exception {
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//
//		ctx.register(AppConfig.class);
//		ctx.refresh();
//
//		ExecutionController task = ctx.getBean(ExecutionController.class);
		
		ExecutionController task = new ExecutionController();
		
		task.executionStartStop(req);
		task.executionStartStop(req);
		task.executionStartStop(req);
		return "redirect:BrokerMainScreen.jsp";
	}

	@Async
	// @RequestMapping("/views/startStopService")
	public void executionStartStop(HttpServletRequest req) throws URISyntaxException, Exception {
		String start = req.getParameter("start");
		System.out.println("username: " + start);

		AbstractApplicationContext container = new AnnotationConfigApplicationContext(
				com.sapient.config.AppConfig.class);
		container.registerShutdownHook();

		BrokerService brokerService = (BrokerService) container.getBean("brokerService");

		brokerService.StartExecution();

//		return "redirect:BrokerMainScreen.jsp";


	}

	@RequestMapping("views/checkStatus")
	public ModelAndView checkBrokerStatus(HttpServletRequest req) {
		String hostName = "127.0.0.1";
		int portNumber = 61616;
		String result;

		try {
			Socket s = new Socket(hostName, portNumber);
			s.close();
			result = "true";

		} catch (Exception e) {
			result = "false";
			e.printStackTrace();

		}
		req.getSession().setAttribute("status", result);
		System.out.println("the broker status" + result);
		return new ModelAndView("redirect:BrokerMainScreen.jsp", "status", result);

	}

}