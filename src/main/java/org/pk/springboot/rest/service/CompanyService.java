package org.pk.springboot.rest.service;

import org.pk.springboot.rest.domian.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pravin P Patil
 *
 */
@Service
public class CompanyService {

	@Autowired
	private CompanyService companyRepository;

	/**
	 * @param company
	 * @return
	 */
	public Company save(Company company) {
		return companyRepository.save(company);
	}
}