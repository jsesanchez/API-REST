package com.example.demo.LocationDB;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
@DataJpaTest
class LocationTest {
	
	//@Autowired
	Location location; 
	
	private int id=1;
	private String name="Test";
	private int area_m2=100;
	
	@BeforeEach
	public void setUpLocation(){
		location = new Location(id, name, area_m2);
		location.setId(id);
		location.setName(name);
		location.setArea_m2(area_m2);
	}	
	
	@Test 
	public void with_parameterized_constructor() throws Exception{
		location = new Location(id, name, area_m2);
		assertNotNull(location);
		assertEquals(id, location.getId());
		assertEquals(name, location.getName());
		assertEquals(area_m2, location.getArea_m2());
	}
	
	

}
