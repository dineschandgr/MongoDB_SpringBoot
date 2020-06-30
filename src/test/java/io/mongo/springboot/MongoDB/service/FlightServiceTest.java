package io.mongo.springboot.MongoDB.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.mongo.springboot.MongoDB.model.Flight;
import io.mongo.springboot.MongoDB.repository.FlightMongoTemplateRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DisplayName(value = "Spring Boot Flight Service Test")
class FlightServiceTest {

	@Autowired
	FlightService flightService;
	
	@MockBean
	FlightMongoTemplateRepository flightRepositoryMock;

	@DisplayName(value = "Test findFlightByName Method")
	@Test
	public void findFlightByNameTest() {
		
		Map<String,String> passengerMap = new HashMap<String,String>();
		passengerMap.put("name", "dc");
		passengerMap.put("contact", "83471025");
		Flight flight = new Flight(1, 320,"Test", passengerMap);
		List<Flight> flightList = new ArrayList<Flight>();
		flightList.add(flight);
		Optional<Flight> optionalList = flightList.stream().findFirst();
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("Test"));
		when(flightRepositoryMock.findFlightByName(query)).thenReturn(new Flight(1, 320,"Test", passengerMap));
		assertEquals(optionalList.get().getName(),flightService.findFlightByName("Test").getName());
	}

	
}
