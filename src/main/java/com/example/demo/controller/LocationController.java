package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.LocationDB.Location;
import com.example.demo.service.LocationServiceImp;

@RestController
@RequestMapping({"/location"})
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
public class LocationController {
	
	@Autowired
	LocationServiceImp service;
	
	@GetMapping
	public List<Location>listar(){
		return service.listar();
	}
	
	@PostMapping
	public Location agregar(@RequestBody Location l) {
		return service.add(l);
	}
	@GetMapping(path = {"/{id}"})
	public Location listarID(@PathVariable("id") int id) {
		return service.listarID(id);
	}
	@PutMapping(path = {"/{id}"})
	public Location editar(@RequestBody Location l,@PathVariable("id") int id) {
		l.setId(id);
		return service.edit(l);
	}
	@DeleteMapping(path = {"/{id}"})
	public Location delete(@PathVariable("id") int id) {
		return service.delete(id);
	}
}
