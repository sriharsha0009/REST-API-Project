package com.project.bean;

import java.util.List;

public class TransactionList {

	List<Transaction> transactions;
	
	public TransactionList() {
		
	}

	public TransactionList(List<Transaction> transactions) {
		super();
		this.transactions = transactions;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
}
