package com.example.demo.service;

import org.springframework.data.repository.Repository;
import java.util.List;
import com.example.demo.LocationDB.Location;

public interface ILocationRepo extends Repository<Location, Integer>{
	List<Location>findAll();
	Location findById(int id);
	Location save(Location l);
	void delete(Location l);
}
