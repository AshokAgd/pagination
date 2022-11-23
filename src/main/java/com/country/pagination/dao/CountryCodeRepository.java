package com.country.pagination.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.country.pagination.model.Country;
import com.country.pagination.specification.UserSpecification;

@Repository
public interface CountryCodeRepository extends PagingAndSortingRepository{

	Page<Country> findAll(UserSpecification spec, Pageable pageable);

}
