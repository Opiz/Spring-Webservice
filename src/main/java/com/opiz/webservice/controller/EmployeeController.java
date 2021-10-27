package com.opiz.webservice.controller;

import com.opiz.webservice.dao.EmployeeDao;
import com.opiz.webservice.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/")
    public String welcome() {
        return "Welcome to RestTemplate Example";
    }

    // URL:
    // http://localhost:8080/employees
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/employees",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Employee> getEmployees() {
        return employeeDao.getAll();
    }

    // URL:
    // http://localhost:8080/employee/{empNo}
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/employee/{empNo}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee getEmployee(@PathVariable("empNo") long empNo) {
        return employeeDao.get(empNo);
    }

    // URL:
    // http://localhost:8080/employee
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/employee",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeDao.save(employee);
    }

    // URL:
    // http://localhost:8080/employee
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/employee",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeDao.update(employee);
    }

    // URL:
    // http://localhost:8080/employee
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/employee/{empNo}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee deleteEmployee(@PathVariable long empNo) {
        return employeeDao.delete(employeeDao.get(empNo));
    }
}
