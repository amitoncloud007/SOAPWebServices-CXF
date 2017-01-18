package com.amityas.ws.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.amityas.customerorder.CreateOrderRequest;
import org.amityas.customerorder.CreateOrderResponse;
import org.amityas.customerorder.CustomerOrderPortType;
import org.amityas.customerorder.DeleteOrderRequest;
import org.amityas.customerorder.DeleteOrderResponse;
import org.amityas.customerorder.GetOrdersRequest;
import org.amityas.customerorder.GetOrdersResponse;
import org.amityas.customerorder.Order;
import org.amityas.customerorder.Product;

public class CustomerOrderPortTypeImpl implements CustomerOrderPortType {
	Map<BigInteger, List<Order>> orderMap = new HashMap<>();
	long orderid = 0;
	long customerid = 0;
	long productid = 0;

	public void init() {

		List<Order> orderList = new ArrayList<>();
		Order order = new Order();
		order.setOrderId(BigInteger.valueOf(++orderid));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "iPhone 7", "iPhone 7 32GB"));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "iPhone 6", "iPhone 6 32GB"));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "iPhone 5", "iPhone 5 32GB"));
		orderList.add(order);

		order = new Order();
		order.setOrderId(BigInteger.valueOf(++orderid));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "Android 7", "Android 7 32GB"));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "Android 6", "Android 6 32GB"));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "Android 5", "Android 5 32GB"));
		orderList.add(order);

		orderMap.put(BigInteger.valueOf(++customerid), orderList);

		orderList = new ArrayList<>();

		order = new Order();
		order.setOrderId(BigInteger.valueOf(++orderid));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "iPhone 7", "iPhone 7 32GB"));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "iPhone 6", "iPhone 6 32GB"));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "iPhone 5", "iPhone 5 32GB"));
		orderList.add(order);

		order = new Order();
		order.setOrderId(BigInteger.valueOf(++orderid));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "iPhone 7", "iPhone 7 32GB"));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "iPhone 6", "iPhone 6 32GB"));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "iPhone 5", "iPhone 5 32GB"));
		orderList.add(order);

		orderMap.put(BigInteger.valueOf(++customerid), orderList);

	}

	public CustomerOrderPortTypeImpl() {
		init();

	}

	private Product getProduct(BigInteger id, String name, String desc) {
		Product product = new Product();
		product.setProductId(id);
		product.setProductDesc(name);
		product.setProductName(desc);
		return product;
	}

	@Override
	public GetOrdersResponse getOrders(GetOrdersRequest parameters) {

		BigInteger customerId = parameters.getCustomerId();
		List<Order> orderList = orderMap.get(customerId);
		GetOrdersResponse getOrdersResponse = new GetOrdersResponse();
		if (orderList != null) {

			getOrdersResponse.getOrders().addAll(orderList);

			for (Order order : getOrdersResponse.getOrders()) {
				System.out.println("Order " + order.getOrderId());
			}
		}
		return getOrdersResponse;
	}

	@Override
	public CreateOrderResponse createOrder(CreateOrderRequest parameters) {

		BigInteger customerId = parameters.getCustomerId();

		Order order = new Order();
		List<Order> orderList = new ArrayList<>();
		order.setOrderId(BigInteger.valueOf(4));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "HTC 7", "HTC 7 32GB"));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "HTC 6", "HTC 6 32GB"));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "HTC 5", "HTC 5 32GB"));
		orderList.add(order);

		order = new Order();
		order.setOrderId(BigInteger.valueOf(4));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "iPhone 7", "iPhone 7 32GB"));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "iPhone 6", "iPhone 6 32GB"));
		order.getProducts().add(getProduct(BigInteger.valueOf(++productid), "iPhone 5", "iPhone 5 32GB"));
		orderList.add(order);

		List<Order> list = orderMap.get(customerId);

		if (list != null) {
			list.addAll(orderList);
			orderMap.put(customerId, list);
		} else {
			orderMap.put(customerId, orderList);
		}

		CreateOrderResponse createOrderResponse = new CreateOrderResponse();

		createOrderResponse.setSuccess(true);

		return createOrderResponse;
	}

	@Override
	public DeleteOrderResponse deleteOrder(DeleteOrderRequest parameters) {

		BigInteger custId = parameters.getCustomerId();
		orderMap.remove(custId);
		
		
		DeleteOrderResponse deleteOrderResponse = new DeleteOrderResponse();
		deleteOrderResponse.setSuccess(true);
		
		
		return deleteOrderResponse;
	}

}
