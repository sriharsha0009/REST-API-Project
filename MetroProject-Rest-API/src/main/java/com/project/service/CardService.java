package com.project.service;

import java.util.ArrayList;

import com.project.bean.Card;
import com.project.bean.CardList;

public interface CardService {

	Card storeCardDetails(Card passenger);
	//boolean getSwipeInStatus(int cardId)throws ClassNotFoundException, SQLException;
	int rechargeCard(int cardId,int amount);
	Card checkCard(int cardId);
	int updateFare(int cardId, int fare);
	int checkFare(int cardNumber, int i);
	Card updateCardBalance(int cardNumber, int amount);
	int returnCardId();
	CardList getCards();
	int deleteCard(int cId);
}
