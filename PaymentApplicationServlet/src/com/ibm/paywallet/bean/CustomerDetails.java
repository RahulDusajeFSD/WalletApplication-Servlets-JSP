package com.ibm.paywallet.bean;

public class CustomerDetails {
	
	
	public CustomerDetails(int amount) {
	
		this.amount = amount;
	}
	private String name;
	private String AccountNo;
	private String Address;
	private String ContactNo;
	public CustomerDetails(String name,  String age,String contactNo,String pin, String address) {
		this.name = name;
		Address = address;
		ContactNo = contactNo;
		this.age = age;
		Pin = pin;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(String accountNo) {
		AccountNo = accountNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPin() {
		return Pin;
	}
	public void setPin(String pin) {
		Pin = pin;
	}
	public String getDeposit() {
		return Deposit;
	}
	public void setDeposit(String deposit) {
		Deposit = deposit;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getToContact() {
		return ToContact;
	}
	public void setToContact(String toContact) {
		ToContact = toContact;
	}
	public String getWithdraw() {
		return Withdraw;
	}
	public void setWithdraw(String withdraw) {
		Withdraw = withdraw;
	}
	public String getFundTransfer() {
		return FundTransfer;
	}
	public void setFundTransfer(String fundTransfer) {
		FundTransfer = fundTransfer;
	}
	public String getTransaction() {
		return Transaction;
	}
	public void setTransaction(String transaction) {
		Transaction = transaction;
	}
	private String age;
	private String Pin;
	
	
	
	
	public CustomerDetails(String name, String pin) {
		this.name = name;
		Pin = pin;
	}
	private String Deposit;
	private int amount;
	private String ToContact;
	private  String Withdraw;
	public CustomerDetails(int amount,String ContactNo) {
		super();
		this.ContactNo=ContactNo;
		this.amount = amount;
	}
	
	private  String FundTransfer;
	private String Transaction;
	
	
	

}
