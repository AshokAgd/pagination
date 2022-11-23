package com.country.pagination.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.country.pagination.dao.CountryCodeRepository;
import com.country.pagination.model.Country;
import com.country.pagination.specification.SearchCriteria;
import com.country.pagination.specification.UserSpecification;


@Component
public class CountryCodeService {

	private CountryCodeRepository repository;
	
	public List<Country> getCountryCodeList(Integer pageNo, Integer pageSize, String search, String sortBy) {
		Page<Country> pageResult;
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		 UserSpecification spec = new UserSpecification(new SearchCriteria("name", ":", "united"));
		 pageResult = repository.findAll(spec, pageable);
		 return pageResult.getContent();
		//pageResult = repository.findAll(Specification.where(vendorSpec.and(groupIdSpec)).and(new CxpSpecifications<Thing>().getSpecifications(search, allowedThingSearchSort)), pageable);
		
	}
	

}
