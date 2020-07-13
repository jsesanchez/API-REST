package com.example.demo.service;

import java.util.List;

import com.example.demo.LocationDB.Location;

public interface ILocationService {
	List<Location>listar();
	Location listarID(int id);
	Location add(Location l);
	Location edit(Location l);
	Location delete(int id);
	
}
