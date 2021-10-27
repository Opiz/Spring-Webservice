package com.opiz.webservice.dao;

import com.opiz.webservice.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class EmployeeDao implements Dao<Employee> {

    private static final Map<Long, Employee> empMap = new HashMap<>();

    static {
        initEmps();
    }

    private static void initEmps() {
        Employee emp1 = new Employee(1L, "Smith", "Clerk");
        Employee emp2 = new Employee(2L, "Allen", "Salesman");
        Employee emp3 = new Employee(3L, "Jones", "Manager");

        empMap.put(emp1.getEmpNo(), emp1);
        empMap.put(emp2.getEmpNo(), emp2);
        empMap.put(emp3.getEmpNo(), emp3);
    }


    @Override
    public Employee get(long id) {
        return empMap.get(id);
    }

    @Override
    public List<Employee> getAll() {
        Collection<Employee> list = empMap.values();
        return new ArrayList<>(list);
    }

    @Override
    public Employee save(Employee employee) {
        return empMap.put(employee.getEmpNo(), employee);
    }

    @Override
    public Employee update(Employee employee) {
        return empMap.put(employee.getEmpNo(), employee);
    }

    @Override
    public Employee delete(Employee employee) {
        return empMap.remove(employee.getEmpNo());
    }
}
