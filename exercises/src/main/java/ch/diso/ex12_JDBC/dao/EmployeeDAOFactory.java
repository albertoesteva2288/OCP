package ch.diso.ex12_JDBC.dao;

public class EmployeeDAOFactory {

    public EmployeeDAO createEmployeeDAO() {

        // Implement EmployeeDAOJDBCImpl() to be used instead of this
        // in-memory version.
        return new EmployeeDAOMemoryImpl();
    }
}