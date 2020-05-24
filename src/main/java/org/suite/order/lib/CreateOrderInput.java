package org.suite.order.lib;

//import java.io.Serializable;


public class CreateOrderInput{
	
	CreateOrderInput()
	{
		
	}

	private String customerId;
	private String offer;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}

	@Override
	public String toString() {
	        return getClass().getName() + " @ " + getCustomerId() + "\t" + getOffer();
	}
	
}
