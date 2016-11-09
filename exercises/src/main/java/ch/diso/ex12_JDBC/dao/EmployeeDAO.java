package ch.diso.ex12_JDBC.dao;


import ch.diso.ex12_JDBC.model.Employee;

public interface EmployeeDAO extends AutoCloseable {

    void add(Employee emp) throws DAOException;

    void update(Employee emp) throws DAOException;

    void delete(int id) throws DAOException;

    Employee findById(int id) throws DAOException;

    Employee[] getAllEmployees() throws DAOException;

}