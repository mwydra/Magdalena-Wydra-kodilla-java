package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchingFacade {
    @Autowired
    private CompanyDao company;
    @Autowired
    private EmployeeDao employee;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchingFacade.class);

    public List<Company> searchCompany(String string) throws SearchingException {
        if(string == null){
            LOGGER.error(SearchingException.ERR_SEARCHING);
            throw new SearchingException(SearchingException.ERR_SEARCHING);
        }
        List<Company> companies = company.searchByFragment("%" + string + "%");
        LOGGER.info("Found companies: " + companies.iterator().next().getName());
        return companies;
    }

    public List<Employee> searchEmployee(String string) throws SearchingException {
        if(string == null){
            LOGGER.error(SearchingException.ERR_SEARCHING);
            throw new SearchingException(SearchingException.ERR_SEARCHING);
        }
        List<Employee> employees = employee.searchByFragment("%" + string + "%");
        LOGGER.info("Found employees: " + employees.iterator().next().getLastname());
        return employees;
    }
}
