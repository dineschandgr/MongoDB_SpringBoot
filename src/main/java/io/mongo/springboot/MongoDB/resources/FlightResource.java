package io.mongo.springboot.MongoDB.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.mongo.springboot.MongoDB.model.Flight;
import io.mongo.springboot.MongoDB.model.Product;
import io.mongo.springboot.MongoDB.service.FlightService;

@RestController
public class FlightResource {
	
	@Autowired
	FlightService flightService;

	@PostMapping(value="/flight/createFlight")
	public Flight createProduct(@RequestBody Flight flight) {
		return flightService.createFlight(flight);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/flight/getFlights")
	public List<Product> getAllFlights() {
		return flightService.getAllFlights();
	}
	
	@PutMapping(value="/flight/updateFlight")
	public Flight updateFlight(@RequestBody Flight flight) { 
	   return flightService.updateFlight(flight); 
	 }
	
	@GetMapping(value="/flight/getPassengerInfo/{id}/{key}")
	public Flight getPassengerInfo(@PathVariable String id, @PathVariable String key) { 
	   return flightService.getPassengerInfo(id, key); 
	 }
	
	@GetMapping(value="/flight/findFlightByName/{name}")
	public Flight findFlightByName(@PathVariable String name) { 
	   return flightService.findFlightByName(name); 
	 }
	
	
	@DeleteMapping(value="/flight/deleteFlight/{id}") 
	public void deleteProduct(@PathVariable int id) { 
		flightService.deleteFlight(id); 
	}
	 
	
}
