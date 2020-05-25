package org.suite.order.rest;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.suite.order.lib.CreateOrderInput;
import org.suite.order.lib.CreateOrderOutput;
import org.suite.order.lib.UpdateOrderInput;
import org.suite.order.lib.UpdateOrderOutput;
import org.suite.order.services.intf.IOrderInnerService;
import org.suite.order.services.intf.IOrderServices;

@RestController 
@RequestMapping("/order")
public class OrderServices implements IOrderServices{

	
	@Autowired IOrderInnerService orderService;
	
	//@PostMapping(path= "/createOrder", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public CreateOrderOutput createOrder(@RequestBody CreateOrderInput orderInput, @RequestParam String sc)
	{
	
		
		CreateOrderOutput output = new CreateOrderOutput();
	
		System.out.println("sc = "+ sc);
		System.out.println(orderInput);
		
		
		orderService.createOrder(orderInput.getCustomerId(),orderInput.getOffer());
		
		output.setOrderId("123A");
		//return ResponseEntity.ok(output);
		return output;
	}
	
	
	@RequestMapping(value = "/updateOrder/{id}", method = RequestMethod.POST)
	public UpdateOrderOutput updateOrder(@RequestBody UpdateOrderInput orderInput,@PathVariable("id") String id)
	{
		UpdateOrderOutput orderOutput = new UpdateOrderOutput();
		
		orderOutput.setOrderId(id);
		orderOutput.setCustomerId(orderInput.getCustomerId());
		orderOutput.setOffer(orderInput.getOffer());
		
		return orderOutput;
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public CreateOrderOutput getOrderDetails(@PathVariable("id") String id)
	{
		CreateOrderOutput output = new CreateOrderOutput();
		
		
		output.setOrderId(id);
		return output;
	}
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteOrder(@PathVariable("id") String id)
	{
		return "Order " + id + " Deleted";
	}
	
}
