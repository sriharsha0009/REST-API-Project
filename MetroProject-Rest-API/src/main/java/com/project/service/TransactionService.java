package com.project.service;

import java.util.ArrayList;

import com.project.bean.Card;
import com.project.bean.Station;
import com.project.bean.Transaction;
import com.project.bean.TransactionList;

public interface TransactionService {

//	int swipeInStatus(Card cardId);
//	boolean swipeInCard(Card cardId, Station stationId);
//	int[] swipeOut(Card cardId);
//	boolean swipeOutUpdate(int stationId,int transactionId, int fare);
//	int checkPenality(int transactionId);
//	boolean updatePenality(int swipeIn, int i);
	Transaction displayDetails(int transactionId);
	TransactionList getTransaction(Card card);
}
