/**
 * Copyright(C) 2016 Luvina Software Company
 * InsuranceServiceImpl.java Sep 9, 2016 nguyenducthien
 */
package manager.thien.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manager.thien.models.Insurance;
import manager.thien.repository.InsuranceRepository;

/**
 * Implement interface InsuranceService
 * @author nguyenducthien
 *
 */
@Service
public class InsuranceServiceImpl implements InsuranceService{

	@Autowired
	InsuranceRepository insuranceRepository;

	/* (non-Javadoc)
	 * @see manager.thien.services.InsuranceService#getInsuranceById(int)
	 */
	@Override
	public Insurance getInsuranceById(int id) {
		return insuranceRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see manager.thien.services.InsuranceService#isExistByCodeAndId(java.lang.String, int)
	 */
	@Override
	public Boolean isExistByCodeAndId(String code, int id) {
		return (insuranceRepository.findByCodeAndIdNot(code, id) != null) ? true : false;
	}
	
}
