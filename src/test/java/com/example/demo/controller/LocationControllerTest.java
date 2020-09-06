package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.LocationDB.Location;
import com.example.demo.service.ILocationRepo;
import com.example.demo.service.LocationServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
class LocationControllerTest {
	
	@Autowired
	private MockMvc mocMvc;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Mock
	private LocationServiceImp service;
	
	@MockBean
	private ILocationRepo repositorio;
	
	@InjectMocks
	private LocationController locationController;
	
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
	void listarTest() throws Exception{
		List<Location> listLocation= new ArrayList<>();
		listLocation.add(location);
		listLocation.add(location2);
		Mockito.when(service.listar()).thenReturn(listLocation);
		assertNotNull(listLocation);
		assertEquals(id, listLocation.get(id).getId());
		assertEquals(name, listLocation.get(id).getName());
		assertEquals(area_m2, listLocation.get(id).getArea_m2());
		assertEquals(id2, listLocation.get(id2).getId());
		assertEquals(name2, listLocation.get(id2).getName());
		assertEquals(area_m2_2, listLocation.get(id2).getArea_m2());
	}
	@Test
	void ListarIDtest() throws Exception{
		Mockito.when(service.listarID(id)).thenReturn(location);
		assertNotNull(location);
		assertEquals(id, location.getId());
		assertEquals(name, location.getName());
		assertEquals(area_m2, location.getArea_m2());
	}
	@Test
	void agregarTest() throws Exception{
		Mockito.when(service.add(location)).thenReturn(null);
	}
	@Test
	void eliminarTest() throws Exception{
		Mockito.when(service.delete(id)).thenReturn(null);
	}
	
}
