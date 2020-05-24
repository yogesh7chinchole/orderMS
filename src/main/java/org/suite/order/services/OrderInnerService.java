package org.suite.order.services;

import org.springframework.stereotype.Service;
import org.suite.order.services.intf.IOrderInnerService;

@Service
public class OrderInnerService  implements IOrderInnerService{

	
	public void createOrder(String customerId,String offerId)
	{
		System.out.println("Order Created:"+ customerId + " Offer: "+offerId);
	}
	
}
