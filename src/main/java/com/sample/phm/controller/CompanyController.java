package com.sample.phm.controller;

import com.sample.phm.entity.Company;
import com.sample.phm.entity.CompanyResponse;
import com.sample.phm.entity.DeleteResponse;
import com.sample.phm.exception.BadCompanyCredentialException;
import com.sample.phm.exception.CompanyNotExitsException;
import com.sample.phm.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
class CompanyController {
    
    @Autowired
    private CompanyService companyService;

    /**
     * Gets a List of all companies present into the database.
     * @return ArrayList<Company>
     */
    @GetMapping("/company")
    public ArrayList<Company> getAllCompany() {
        return companyService.getAllCompany();
    }

    /**
     * Add a company into database
     * @param company
     * @return CompanyResponse
     * @throws BadCompanyCredentialException
     */
    @PostMapping("/company")
    public CompanyResponse addNewCompany(@RequestBody Company company) throws BadCompanyCredentialException {
        if(companyService.addCompany(company)){
            return new CompanyResponse(HttpStatus.ACCEPTED, true, "company added successfully");
        } else
            throw new BadCompanyCredentialException("Credentials are not sufficient");
    }

    /**
     * Fetch a company By id if present into the database
     * @param id
     * @param company
     * @return Company
     * @throws CompanyNotExitsException
     */
    @PutMapping("/company/{id}")
    public Company updateCompany(@PathVariable Integer id,@RequestBody Company company) throws CompanyNotExitsException {
        try{
            return companyService.updateCompany(id,company);
        } catch (Exception e) {
            throw new CompanyNotExitsException(e.getMessage());
        }
    }

    /**
     * Delete a particular company if present into the database.
     * @param id
     * @return DeleteResponse
     * @throws CompanyNotExitsException
     */
    @DeleteMapping("/company/{id}")
    public DeleteResponse deleteCompany(@PathVariable Integer id) throws CompanyNotExitsException {
        if(companyService.deleteById(id))
            return new DeleteResponse(HttpStatus.FOUND, true, "Company deleted successfully");
        else
            throw new CompanyNotExitsException("Company of this id not existed");
    }
    
}
