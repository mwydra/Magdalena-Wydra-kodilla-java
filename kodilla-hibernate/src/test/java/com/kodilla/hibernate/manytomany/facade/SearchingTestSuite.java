package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchingTestSuite {
    @Autowired
    private SearchingFacade searchingFacade;
    @Autowired
    CompanyDao company;
    @Autowired
    EmployeeDao employee;

    @Before
    public void setUp(){
        for (Company company1 : company.findAll()) {
            company.delete(company1);
        }
        for (Employee employee1 : employee.findAll()) {
            employee.delete(employee1);
        }
    }

    @Test
    public void testSearchingCompany() throws SearchingException {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        company.save(softwareMachine);
        company.save(dataMaesters);
        company.save(greyMatter);

        //When
        List<Company> companies = searchingFacade.searchCompany("oft");

        //Then
        Assert.assertEquals(1, companies.size());
        Assert.assertEquals("Software Machine", companies.get(0).getName());
    }

    @Test(expected = SearchingException.class)
    public void testSearchingCompanyEmptyName() throws SearchingException {
        //When
        List<Company> companies = searchingFacade.searchCompany(null);

        //Then
        fail("Should not be here");
    }

    @Test
    public void testSearchingEmployee() throws SearchingException {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        employee.save(johnSmith);
        employee.save(stephanieClarckson);
        employee.save(lindaKovalsky);

        //When
        List<Employee> employees = searchingFacade.searchEmployee("larc");

        //Then
        Assert.assertEquals(1, employees.size());
        Assert.assertEquals("Clarckson", employees.get(0).getLastname());
    }

    @Test(expected = SearchingException.class)
    public void testSearchingEmployeeEmptyName() throws SearchingException {
        //When
        List<Employee> employees = searchingFacade.searchEmployee(null);

        //Then
        fail("Should not be here");
    }

}
