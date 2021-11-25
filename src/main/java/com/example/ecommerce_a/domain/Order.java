package com.example.ecommerce_a.domain;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;

public class Order {
	// id
	private Integer id;
	// ユーザーid
	private Integer userId;
	// 注文状況
	private Integer status;
	// 合計金額
	private Integer totalPrice;
	// 注文日
	private Date orderDate;
	// 宛先氏名
	private String destinationName;
	// 宛先Eメール
	private String destinationEmail;
	// 宛先郵便番号
	private String destinationZipcode;
	// 宛先住所
	private String destinationAddress;
	// 宛先TEL
	private String destinationTel;
	// 配達時間帯
	private Timestamp deliveryTime;
	// 支払方法
	private Integer paymentMethod;
	// ユーザ
	private User user;
	// 注文商品
	private List<OrderItem> orderItemList;
	
	/**
	 * 注文商品ごとに消費税額を算出する
	 * @return 消費税の合計金額
	 */
	public int getTax() {
		int taxTotal = 0;
		for (OrderItem orderItem : orderItemList) {
			taxTotal += (int)(orderItem.getSubTotal() * 0.1);
		}
		return taxTotal;
	}
	
	/**
	 * 注文商品ごとに税込金額を算出する
	 * @return 税込の合計金額
	 */
	public int getCalcTotalPrice() {
		int taxTotal = 0;
		for (OrderItem orderItem : orderItemList) {
			taxTotal += (int)(orderItem.getSubTotal() * 1.1);
		}
		return taxTotal;
	}

	// getter/setterを定義
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getDestinationEmail() {
		return destinationEmail;
	}

	public void setDestinationEmail(String destinationEmail) {
		this.destinationEmail = destinationEmail;
	}

	public String getDestinationZipcode() {
		return destinationZipcode;
	}

	public void setDestinationZipcode(String destinationZipcode) {
		this.destinationZipcode = destinationZipcode;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public String getDestinationTel() {
		return destinationTel;
	}

	public void setDestinationTel(String destinationTel) {
		this.destinationTel = destinationTel;
	}

	public Timestamp getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Timestamp deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Integer getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", status=" + status + ", totalPrice=" + totalPrice
				+ ", orderDate=" + orderDate + ", destinationName=" + destinationName + ", destinationEmail="
				+ destinationEmail + ", destinationZipcode=" + destinationZipcode + ", destinationAddress="
				+ destinationAddress + ", destinationTel=" + destinationTel + ", deliveryTime=" + deliveryTime
				+ ", paymentMethod=" + paymentMethod + ", user=" + user + ", orderItemList=" + orderItemList + "]";
	}
	
}
