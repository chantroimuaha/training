/**
 * Copyright(C) 2016 Luvina Software Company
 * CompanyRepository.java Sep 12, 2016 nguyenducthien
 */
package manager.thien.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import manager.thien.models.Company;

/**
 * Interface cho lớp company
 * @author nguyenducthien
 *
 */
@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Integer>{
	List<Company> findAll(Sort sort);
}
