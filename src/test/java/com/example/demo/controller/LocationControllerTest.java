package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.LocationDB.Location;
import com.example.demo.service.ILocationRepo;
import com.example.demo.service.LocationServiceImp;

@DataJpaTest 
class LocationControllerTest {
	
	@Mock
	private LocationServiceImp service;
	
	@Mock
	private ILocationRepo repositorio;
	
	@InjectMocks
	private LocationController locationController = new LocationController();
	
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
		List<Location> listlocation2 = locationController.listar();
		assertNotNull(listlocation2);
		assertEquals(id, listlocation2.get(id).getId());
		assertEquals(name, listlocation2.get(id).getName());
		assertEquals(area_m2, listlocation2.get(id).getArea_m2());
		assertEquals(id2, listlocation2.get(id2).getId());
		assertEquals(name2, listlocation2.get(id2).getName());
		assertEquals(area_m2_2, listlocation2.get(id2).getArea_m2());
	}
	@Test
	void ListarIDtest() throws Exception{
		Mockito.when(service.listarID(id)).thenReturn(location);
		Location result = locationController.listarID(id);
		assertNotNull(result);
		assertEquals(id, result.getId());
		assertEquals(name, result.getName());
		assertEquals(area_m2, result.getArea_m2());
		
	}
	@Test
	void agregarTest() throws Exception{
		Mockito.when(service.add(location)).thenReturn(location);
		Location result = locationController.agregar(location);
		assertNotNull(result);
		assertEquals(id, result.getId());
		assertEquals(name, result.getName());
		assertEquals(area_m2, result.getArea_m2());
		
	}
	@Test
	void eliminarTest() throws Exception{
		Mockito.when(locationController.delete(id)).thenReturn(null);
		
	}
	@Test
	void editarTest() throws Exception{
		Mockito.when(service.edit(location)).thenReturn(location);
		Location result = locationController.editar(location, id);
		assertNotNull(result);
		assertEquals(id, result.getId());
		assertEquals(name, result.getName());
		assertEquals(area_m2, result.getArea_m2());
		
	}
	
}
