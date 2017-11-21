/**
 * Copyright(C) 2016 Luvina Software Company
 * CompanyServiceImpl.java Sep 8, 2016 nguyenducthien
 */
package manager.thien.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import manager.thien.models.Company;
import manager.thien.repository.CompanyRepository;

/**
 * Concrete class của CompanyService
 * @author nguyenducthien
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	/* (non-Javadoc)
	 * @see manager.thien.services.CompanyService#getAllCompany()
	 */
	@Override
	public List<Company> getAllCompany() {
		Sort fullNameASC = new Sort(Sort.Direction.ASC, "name");
		return companyRepository.findAll(fullNameASC);
	}
	/* (non-Javadoc)
	 * @see manager.thien.services.CompanyService#getCompanyById(int)
	 */
	@Override
	public Company getCompanyById(int id) {
		return companyRepository.findOne(id);
	}
	

}
