package org.amityas.customerorder.ws.client;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

import org.amityas.customerorder.CreateOrderRequest;
import org.amityas.customerorder.CustomerOrder;
import org.amityas.customerorder.CustomerOrderPortType;
import org.amityas.customerorder.GetOrdersRequest;
import org.amityas.customerorder.GetOrdersResponse;
import org.amityas.customerorder.Order;
import org.amityas.customerorder.Product;

public class CustomerOrderClient {

	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("http://localhost:8080/CustomerOrderWS/services/customerOrders?wsdl");
			CustomerOrder service = new CustomerOrder(url);
			CustomerOrderPortType customerPort= service.getCustomerOrderSOAP();
			CreateOrderRequest createOrderRequest = new CreateOrderRequest();
			GetOrdersRequest getOrderRequest = new GetOrdersRequest();
			getOrderRequest.setCustomerId(BigInteger.valueOf(4));
			GetOrdersResponse orders = customerPort.getOrders(getOrderRequest);
			 
			 
			 for (Order order : orders.getOrders()) {
				System.out.println("====================================================");
				 BigInteger orderId = order.getOrderId();
				 System.out.println("Oder Number "+orderId);
				 for (Product product : order.getProducts()) {
					
					 System.out.println("Product Name "+product.getProductName());
					 System.out.println("Product Desc "+product.getProductDesc());
				}
				 
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
