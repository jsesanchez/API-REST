package com.example.demoLocationDB;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;


import org.junit.Before;

import com.example.demo.LocationDB.Location;



public class LocationTest {
	private int id=1;
	private String name="Test";
	private int area_m2=100;
	private Location location; 
	
	@Before
	public void setUpLocation(){
		location.setId(id);
		location.setName(name);
		location.setArea_m2(area_m2);
		System.out.println("Entro Before");
	}
	
	
	@Test 
	public void with_parameterized_constructor() throws Exception{
		System.out.println("Entro Test 2");
		location = new Location(id, name, area_m2);
		assertNotNull(location);
		assertEquals(id, location.getId());
		assertEquals(name, location.getName());
		assertEquals(area_m2, location.getArea_m2());
	}
}
