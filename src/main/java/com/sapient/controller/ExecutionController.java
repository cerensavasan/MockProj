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
import com.sapient.model.Securities;
import com.sapient.model.User;
import com.sapient.service.BrokerService;
import com.sapient.service.BrokerServiceImpl;
import com.sapient.service.SecuritiesService;
import com.sapient.service.UserService;

@Controller
public class ExecutionController {

	@RequestMapping("/views/startStopService")
	public String startThreadExecution(HttpServletRequest req) throws URISyntaxException, Exception {
		// AnnotationConfigApplicationContext ctx = new
		// AnnotationConfigApplicationContext();
		//
		// ctx.register(AppConfig.class);
		// ctx.refresh();
		//
		// ExecutionController task = ctx.getBean(ExecutionController.class);

		ExecutionController task = new ExecutionController();
		if (checkBroker()) {
			task.executionStartStop(req);
			task.executionStartStop(req);
			task.executionStartStop(req);
			return "redirect:BrokerMainScreen.jsp";
		}
		return "redirect:ErrorPage.jsp";
		/*
		 * StopController stopController=new StopController();
		 * 
		 * while(stopController.getFlag()) {
		 */

		// }

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

		// return "redirect:BrokerMainScreen.jsp";

	}

	/*
	 * @RequestMapping("/views/editSecurity1") public String
	 * executionStartStop1(HttpServletRequest req) {
	 * System.out.println("executionStartStop1");
	 * 
	 * // * System.out.println("executionStartStop"); String stop = // *
	 * req.getParameter("stop"); System.out.println("password: " + stop);
	 * 
	 * Securities security = new Securities(); String symbol =
	 * req.getParameter("ticker"); String symbolName =
	 * req.getParameter("Symbol name"); String last_trade_price =
	 * req.getParameter("Last traded Price"); String max_price_spread =
	 * req.getParameter("Maximum Price Spread "); String max_executions =
	 * req.getParameter("Maximum Executions Per Order "); String max_interval =
	 * req.getParameter("Maximum Interval "); String prob_percent =
	 * req.getParameter("Maximum Probable Percentage");
	 * 
	 * AbstractApplicationContext container = new
	 * AnnotationConfigApplicationContext( com.sapient.config.AppConfig.class);
	 * container.registerShutdownHook(); SecuritiesService securitiesService =
	 * (SecuritiesService) container.getBean("securitiesService");
	 * System.out.println(symbol); System.out.println("symbolName"+symbolName);
	 * System.out.println("max_executions"+max_executions); security =
	 * securitiesService.findByPrimaryKey(symbol);
	 * security.setLast_trade_price(Double.parseDouble(last_trade_price));
	 * security.setMax_executions(Integer.parseInt(max_executions));
	 * security.setMax_interval(Integer.parseInt(max_interval));
	 * security.setMax_price_spread(Double.parseDouble(max_price_spread));
	 * security.setSecurity_name(symbolName);
	 * security.setProb_percent(Double.parseDouble(prob_percent));
	 * securitiesService.savesecurities(security);
	 * 
	 * return "redirect:ConfigureSecurity.jsp";
	 * 
	 * }
	 */

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

	public boolean checkBroker() {
		String hostName = "127.0.0.1";
		int portNumber = 61616;
		boolean result;

		try {
			Socket s = new Socket(hostName, portNumber);
			s.close();
			result = true;

		} catch (Exception e) {
			result = false;
			e.printStackTrace();

		}
		// req.getSession().setAttribute("status", result);
		System.out.println("the broker status" + result);
		return result;
	}

}