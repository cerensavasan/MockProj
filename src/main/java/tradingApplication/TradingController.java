package tradingApplication;




import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mock.project.config.AppConfig;
import com.mock.project.model.Order;
import com.mock.project.service.TraderService;
import com.mock.project.service.TraderServiceImpl;
import com.mock.project.service.OrderService;
import com.mock.project.service.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;




@Controller
public class TradingController {
		@RequestMapping(value = "/views/fetchOrder", method = RequestMethod.POST)
		    public ModelAndView method(HttpServletRequest req,HttpServletResponse httpServletResponse) {
			//String []out=req.getParameter("check");				
			 System.out.println("test");
			// System.out.println(out);
				
		        //httpServletResponse.setHeader("Location", "www.google.com"); 
				return null;


}
		@RequestMapping(value = "/views/updateTable", method = RequestMethod.GET)
	    public ModelAndView methodToUpdateTable(HttpServletResponse httpServletResponse) 
	    {
	      	System.out.println("Updating the order table with pending orders");
	      	AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
            container.registerShutdownHook();
            OrderService orderService = container.getBean(OrderService.class);
	      	List<Order> p=new ArrayList<Order>();
	      	System.out.println("here2");
	      	p=orderService.displaylist();
	      	System.out.println("here1");
	      for(Order l: p){
	    	  System.out.println("here");
	      		System.out.println(l);
	      	}
	      ModelAndView model = new ModelAndView("PendingOrders");
			model.addObject("Orders",p);

			return model;
	      	
	      // httpServletResponse.setHeader("Location", "www.google.com");
			
	    
	    }  


	@RequestMapping(value = "**/fetchOrder", method = RequestMethod.GET)
    public void method(HttpServletResponse httpServletResponse) {
		System.out.println("test");
        httpServletResponse.setHeader("Location", "www.google.com");}
        
 


	private OrderService orderService;
	
	/*@RequestMapping("/views/CreateOrder")
	public ModelAndView addCreateOrder(@ModelAttribute("order") Order d){
		d.setStatus("New");
		
		System.out.println(d);
		this.orderService.addOrder(d);
		ModelAndView view = new ModelAndView("redirect:index.jsp");
		return view;
	}*/
		
	@RequestMapping("/test")
	public ModelAndView welcomeMessage(@RequestParam(value = "name", required = false) String name) {
		// Name of your jsp file as parameter
		ModelAndView view = new ModelAndView("test");
		view.addObject("name", name);
		return view;
	}

}