package com.example.demoLocationDB.service;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.demo.LocationDB.Location;
import com.example.demo.service.ILocationRepo;

import static org.mockito.ArgumentMatchers.*;


@RunWith(MockitoJUnitRunner.class)
public class LocationServiceImpTest {
	private int id=1;
	private String name="Test";
	private int area_m2=100;
	private Location location; 
	
	@InjectMocks
	private ILocationRepo repositorio;
	
	@Before
	public void setUpDevice(){
		location.setId(id);
		location.setName(name);
		location.setArea_m2(area_m2);
	}
	
}
