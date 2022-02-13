package com.sample.phm.service;

import com.sample.phm.entity.Company;
import com.sample.phm.entity.User;
import com.sample.phm.exception.BadCompanyCredentialException;
import com.sample.phm.exception.BadUserCredentialsException;
import com.sample.phm.exception.CompanyNotExitsException;
import com.sample.phm.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
//import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public ArrayList<Company> getAllCompany(){
        return (ArrayList<Company>) companyRepository.findAll();
    }

    public Company updateCompany(Integer id, Company company) throws CompanyNotExitsException {
        Optional<Company> comp = companyRepository.findById(id);
        if(comp.isPresent()) {
            Company company1 = new Company(
                    comp.get().getId(),
                    company.getName(),
                    company.getAddress(),
                    company.getPhone()
            );
            companyRepository.save(company1);
            return company1;
        } else
            throw new CompanyNotExitsException("Company is not in database");
    }

    public Boolean addCompany(Company company) throws BadCompanyCredentialException {
        try {
            companyRepository.save(company);
            return true;
        } catch (Exception e) {
            throw new BadCompanyCredentialException(e.getMessage());
        }
    }

    public boolean deleteComapnay(Integer id) throws CompanyNotExitsException {
        try{
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new CompanyNotExitsException("Company with this id is not exits");
        }
    }

    public Boolean deleteById(Integer id) throws CompanyNotExitsException {
        try {
            Company company = companyRepository.getById(id);

            if (company != null) {
                companyRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new CompanyNotExitsException("Company not found in Database!");
        }
    }
}
