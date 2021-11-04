package com.project.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.Card;
import com.project.bean.CardList;
import com.project.bean.Station;
import com.project.persistence.CardDao;

@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	private CardDao cardDao;
	

	@Override
	public Card storeCardDetails(Card card){
		//return cardDao.storeDetails(card);
		Card c = cardDao.save(card);
		if (c != null)
			return c;
		return null;
	}

	@Override
	public int returnCardId() {
		try {
		int card= cardDao.returnCardId();
		return card;
		}catch(AopInvocationException e) {
			return 0;
		}
		
	}

	@Override
	public int rechargeCard(int cardId, int amount){
		
		int am= cardDao.rechargeCard(cardId);
		return am+amount;
	}

	@Override
	public Card checkCard(int cardId){
		Card card = cardDao.checkCardDetails(cardId);
//		if(card==null)
//			throw new CardNotFoundException("No card with this number");
//		if(card.getBalance()<20 && choice==2)
//			throw new MinimumBalance("Balance is below 20.");
		return card;
	}

	@Override
	public int updateFare(int cardId, int fare){
		int amount= cardDao.updateFare(cardId);
		return amount-fare;
		
	}

	@Override
	public int checkFare(int cardNumber, int fare){
		int amount= cardDao.updateFare(cardNumber);
		return amount-fare;
	}

	@Override
	public Card updateCardBalance(int cardNumber, int amount){
		int flag= cardDao.updateCardBalance(cardNumber,amount);
		if(flag>0)
			return cardDao.checkCardDetails(cardNumber);
		return null;
	}

	@Override
	public CardList getCards() {
		List<Card> cards =cardDao.findAll();
		CardList cardList = new CardList(cards);
		return cardList;
	}

	@Override
	public int deleteCard(int cId) {
		return cardDao.deleteByCard(cId);
		
	}

}
