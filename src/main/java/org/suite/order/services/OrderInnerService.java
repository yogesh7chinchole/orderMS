package org.suite.order.services;

import org.springframework.stereotype.Service;
import org.suite.order.services.intf.IOrderInnerService;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OrderInnerService  implements IOrderInnerService{

	
	public void createOrder(String customerId,String offerId)
	{
		System.out.println("Retriving customer info: "+ customerId);
		
		WebClient.Builder builder = WebClient.builder();
		
		
		String customer = builder.build()
				.get()
				.uri("http://localhost:7272/customer/get/"+ customerId)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		
		System.out.println("Customer: "+ customer);
		
		System.out.println("Order Created:"+ customerId + " Offer: "+offerId);
	}
	
}
