package com.example.demo.service;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.LocationDB.Location;
import com.example.demo.controller.LocationController;

@WebMvcTest
class LocationServiceImpTest {
	
	@MockBean
	private ILocationRepo repositorio;
	
	@InjectMocks
	private LocationServiceImp service;
	
	Location location; 
	Location location2; 
	private int id=1;
	private String name="Test";
	private int area_m2=100;
	private int id2=1;
	private String name2="Test";
	private int area_m2_2=100;
	
	@BeforeEach
	public void setUpLocation(){
		location = new Location(id, name, area_m2);
		location.setId(id);
		location.setName(name);
		location.setArea_m2(area_m2);
		
		location2 = new Location(id, name, area_m2);
		location2.setId(id2);
		location2.setName(name2);
		location2.setArea_m2(area_m2_2);	
		
	}	
	
	
	@Test
	void ListarIDtest() throws Exception{
		Mockito.when(repositorio.findById(id)).thenReturn(location);
		assertNotNull(location);
		assertEquals(id, location.getId());
		assertEquals(name, location.getName());
		assertEquals(area_m2, location.getArea_m2());
	}
	
	
	@Test
	void addtest() throws Exception{
		Mockito.when(repositorio.save(location)).thenReturn(null);
	}
	
	
	@Test
	void ListAlltest() throws Exception{
		List<Location> listLocation= new ArrayList<>();
		listLocation.add(location);
		listLocation.add(location2);
		Mockito.when(repositorio.findAll()).thenReturn(listLocation);
		assertNotNull(listLocation);
		assertEquals(id, listLocation.get(id).getId());
		assertEquals(name, listLocation.get(id).getName());
		assertEquals(area_m2, listLocation.get(id).getArea_m2());
		assertEquals(id2, listLocation.get(id2).getId());
		assertEquals(name2, listLocation.get(id2).getName());
		assertEquals(area_m2_2, listLocation.get(id2).getArea_m2());
	}
	
	
}
