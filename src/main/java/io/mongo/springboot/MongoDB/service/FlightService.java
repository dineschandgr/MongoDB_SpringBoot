package io.mongo.springboot.MongoDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import io.mongo.springboot.MongoDB.model.Flight;
import io.mongo.springboot.MongoDB.model.Product;
import io.mongo.springboot.MongoDB.repository.FlightMongoTemplateRepository;

@Service
public class FlightService {

	@Autowired
	FlightMongoTemplateRepository flightRepository;
	
	public List<Product> getAllFlights() {
		return flightRepository.findAll();
	}
	
	public Flight createFlight(Flight flight) {
		return flightRepository.createFlight(flight);
	}
	
	public Flight updateFlight(Flight flight) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(flight.getId()));
		Update update = new Update();
		update.set("name", flight.getName());
		update.set("model", flight.getModel());
		return flightRepository.updateFlight(query, update);
	}
	
	public Flight getPassengerInfo(String flightId, String key) {
		Query query = new Query();
		query.fields().include("passengerMap");
		query.addCriteria(Criteria.where("id").is(flightId).andOperator(Criteria.where("passengerMap."+key).exists(true)));
		
		return flightRepository.getPassengerInfo(query);
	}
	
	public Flight findFlightByName(String flightName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(flightName));
		return flightRepository.findFlightByName(query);
	}
	
 
    public void deleteFlight(int flightId) {
    	Query query = new Query();
		query.addCriteria(Criteria.where("id").is(flightId));
		flightRepository.deleteFlight(query);
	}
}
