package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.LocationDB.Location;


public class LocationServiceImp implements ILocationService{

	@Autowired
	private ILocationRepo repositorio;
	
	
	@Override
	public List<Location> listar() {
		return repositorio.findAll();
	}

	@Override
	public Location listarID(int id) {
		return repositorio.findById(id);
	}

	@Override
	public Location add(Location l) {
		return repositorio.save(l);
	}

	@Override
	public Location edit(Location l) {
		return repositorio.save(l);
	}

	@Override
	public Location delete(int id) {
		Location l=repositorio.findById(id);
		if(l!=null) {
			repositorio.delete(l);
		}
		return l;
	}
	

}
