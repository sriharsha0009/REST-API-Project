package com.project.resources;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.bean.Card;
import com.project.bean.CardList;
import com.project.bean.Station;
import com.project.bean.StationList;
import com.project.bean.Transaction;
import com.project.bean.TransactionList;
import com.project.service.CardService;
import com.project.service.StationService;
import com.project.service.TransactionService;

@RestController
public class MetroResource {

	@Autowired
	public StationService stationService;
	@Autowired
	public CardService cardService;
	@Autowired
	public TransactionService transactionService;
	
	
	@RequestMapping(path = "/stations",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StationList> getAllStationsResource(){
		StationList stations= stationService.getStations();
		if(stations.getStations().isEmpty())
			return new ResponseEntity<StationList>(stations, HttpStatus.NO_CONTENT);
		return new ResponseEntity<StationList>(stations, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/stations/{sid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Station> getEmployeeByIdResource(@PathVariable("sid") String sId) {
		Station station= stationService.checkStation(sId);
		if(station==null)
			return new ResponseEntity<Station>(station, HttpStatus.NOT_FOUND);
		return new ResponseEntity<Station>(station, HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "/cards",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CardList> getAllCardsResource(){
		CardList cards= cardService.getCards();
		if(cards.getCards().isEmpty())
			return new ResponseEntity<CardList>(cards, HttpStatus.NO_CONTENT);
		return new ResponseEntity<CardList>(cards, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/cards/{cid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Card> getCardResource(@PathVariable("cid") int cId) {
		Card card= cardService.checkCard(cId);
		if(card==null)
			return new ResponseEntity<Card>(card, HttpStatus.NOT_FOUND);
		return new ResponseEntity<Card>(card, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/transactions/{cid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionList> getTransactionResource(@PathVariable("cid") int cId){
		Card card= cardService.checkCard(cId);
		TransactionList transactions= transactionService.getTransaction(card);
		if(transactions.getTransactions().isEmpty())
			return new ResponseEntity<TransactionList>(transactions, HttpStatus.NO_CONTENT);
		return new ResponseEntity<TransactionList>(transactions, HttpStatus.OK);
	}
	
	
	@DeleteMapping(path="/cards/{cid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Card> deleteCardResource(@PathVariable("cid") int cId) {
		Card card= cardService.checkCard(cId);
		int flag= cardService.deleteCard(cId);
		if(flag<=0)
			return new ResponseEntity<Card>(card, HttpStatus.NO_CONTENT);
		return new ResponseEntity<Card>(card, HttpStatus.OK);
	}
	
	
	@PutMapping(path = "/cards/{cid}/{bal}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Card> updateCardSalaryResource(@PathVariable("cid") int cId,@PathVariable("bal") int balance) {
		Card card= cardService.updateCardBalance(cId, balance);
		if(card==null)
			return new ResponseEntity<Card>(card,HttpStatus.NOT_MODIFIED);
		return new ResponseEntity<Card>(card,HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping(path = "/cards",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Card> insertEmployeeResource(@RequestBody Card card) {
		Card card1= cardService.storeCardDetails(card);
		return new ResponseEntity<Card>(card1, HttpStatus.CREATED);
	}
	

}
