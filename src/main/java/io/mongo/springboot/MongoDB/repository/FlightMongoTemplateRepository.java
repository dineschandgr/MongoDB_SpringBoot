package io.mongo.springboot.MongoDB.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import io.mongo.springboot.MongoDB.model.Flight;

@Repository
public class FlightMongoTemplateRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List findAll() {
		return mongoTemplate.findAll(Flight.class);
	}
	
	public Flight createFlight(Flight flight) {
		return mongoTemplate.save(flight);
	}
	
	public Flight updateFlight(Query query, Update update) {
		return mongoTemplate.findAndModify(query, update, Flight.class);
	}
	
	public Flight getPassengerInfo(Query query) {
		return mongoTemplate.findOne(query, Flight.class);
	}
	
	public Flight findFlightByName(Query query) {
		return mongoTemplate.findOne(query, Flight.class);
	}
	
	public void deleteFlight(Query query) {
		mongoTemplate.remove(query, Flight.class);
	}
	
}
