package com.example.demo.service;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.LocationDB.Location;

@DataJpaTest
class LocationServiceImpTest {
	
	@Mock
	private ILocationRepo repositorio;
	
	@InjectMocks
	private LocationServiceImp service = new LocationServiceImp();
	
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
		Location result = service.listarID(id);
		assertNotNull(result);
		assertEquals(id, result.getId());
		assertEquals(name, result.getName());
		assertEquals(area_m2, result.getArea_m2());
	}
	
	
	@Test
	void addtest() throws Exception{
		Mockito.when(repositorio.save(location)).thenReturn(location);
		Location result = service.add(location);
		assertNotNull(result);
		assertEquals(id, result.getId());
		assertEquals(name, result.getName());
		assertEquals(area_m2, result.getArea_m2());
	}
	

	@Test
	void edittest() throws Exception{
		Mockito.when(repositorio.save(location)).thenReturn(location);
		Location result = service.edit(location);
		assertNotNull(result);
		assertEquals(id, result.getId());
		assertEquals(name, result.getName());
		assertEquals(area_m2, result.getArea_m2());
	}
	
	@Test
	void deletetest() throws Exception{
		Location result = service.delete(id);
	}
	
	@Test
	void deleteNotNulltest() throws Exception{
		Mockito.when(repositorio.findById(id)).thenReturn(location);
		Location result = service.listarID(id);
		Location result2 = service.delete(id);
	}
	
	@Test
	void ListAlltest() throws Exception{
		List<Location> listLocation= new ArrayList<>();
		listLocation.add(location);
		listLocation.add(location2);
		Mockito.when(repositorio.findAll()).thenReturn(listLocation);
		List<Location> listlocation2 = service.listar();
		assertNotNull(listlocation2);
		assertEquals(id, listlocation2.get(id).getId());
		assertEquals(name, listlocation2.get(id).getName());
		assertEquals(area_m2, listlocation2.get(id).getArea_m2());
		assertEquals(id2, listlocation2.get(id2).getId());
		assertEquals(name2, listlocation2.get(id2).getName());
		assertEquals(area_m2_2, listlocation2.get(id2).getArea_m2());
	}
	
	
}
