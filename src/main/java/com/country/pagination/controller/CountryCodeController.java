package com.country.pagination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.country.pagination.model.Country;
import com.country.pagination.service.CountryCodeService;

@RestController
public class CountryCodeController {
	
	@Autowired
	private CountryCodeService service;
	
	@GetMapping(value="/api/countries", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Country>> getCountryCodeList(
			@RequestParam(name = "page", required = false) Integer pageNo,
			@RequestParam(name = "size", required = false) Integer pageSize,
			@RequestParam(name = "q", required = false) String search,
			@RequestParam(name = "sort", required = false) String sort
			) {
		List<Country> countryList=service.getCountryCodeList(pageNo,pageSize,search,sort);
		
		return new ResponseEntity<List<Country>>(countryList, HttpStatus.OK);
		
	}
}
