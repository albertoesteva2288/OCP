package ch.diso.ex12_JDBC.dao;

public class EmployeeDAOFactory {

    public EmployeeDAO createEmployeeDAO() {
        return new EmployeeDAOJDBCImpl();
    }
}