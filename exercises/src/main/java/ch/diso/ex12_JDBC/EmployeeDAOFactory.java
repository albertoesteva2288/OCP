package ch.diso.ex12_JDBC;

import ch.diso.ex04.EmployeeDAO;

public class EmployeeDAOFactory {

    public EmployeeDAO createEmployeeDAO() {
        return new EmployeeDAOJDBCImpl();
    }
}