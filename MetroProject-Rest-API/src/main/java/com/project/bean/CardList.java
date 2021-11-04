package com.project.bean;

import java.util.List;

public class CardList {

	List<Card> cards;
	
	public CardList() {
		
	}

	public CardList(List<Card> cards) {
		super();
		this.cards = cards;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
}
