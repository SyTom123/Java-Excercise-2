package com.javaweb.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;

@RestController
public class BuildingAPI {
	
	@Autowired
	private BuildingService buildingService;
	@GetMapping(value="/api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam(name= "name", required = false)String name,
			@RequestParam(name="districtId", required = false) Long district,
			@RequestParam(name="typeCode", required = false) List<String> typecode
			){
		List<BuildingDTO> result = buildingService.findAll(name, district);
		return result;
	}
}	
