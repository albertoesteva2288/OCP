package ch.diso.ex12_JDBC;

import ch.diso.ex04.Employee;
import ch.diso.ex04.EmployeeDAO;
import ch.diso.ex12_JDBC.DAOException;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAOJDBCImpl implements EmployeeDAO {

    private Connection con = null;

    EmployeeDAOJDBCImpl() {

        String url = "jdbc:mysql://localhost:3306/java_certificate";
        String username = "root";
        String password = "";

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException se) {
            System.out.println("Error obtaining connection with the database: " + se);
            System.exit(-1);
        }
    }

    /**
     * Add an Employee record using an INSERT SQL command
     */
    @Override
    public void add(Employee emp) throws DAOException {
        try (Statement stmt = con.createStatement()) {
            String query = "INSERT INTO EMPLOYEE VALUES (" + emp.getId() + ","
                    + "'" + emp.getFirstName() + "'," + "'" + emp.getLastName() + "',"
                    + "'" + new java.sql.Date(emp.getBirthDate().getTime()) + "'," + emp.getSalary() + ")";
            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("Error adding employee");
            }
        } catch (SQLException se) {
            throw new DAOException("Error adding employee in DAO", se);
        }
    }

    /**
     * Update an employee record with a SQL UPDATE command
     */
    @Override
    public void update(Employee emp) throws DAOException {
        try (Statement stmt = con.createStatement()) {
            String query = "UPDATE EMPLOYEE "
                    + "SET FIRSTNAME='" + emp.getFirstName() + "',"
                    + "LASTNAME='" + emp.getLastName() + "',"
                    + "BIRTHDATE='" + new java.sql.Date(emp.getBirthDate().getTime()) + "',"
                    + "SALARY=" + emp.getSalary()
                    + "WHERE ID=" + emp.getId();
            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("Error updating employee");
            }
        } catch (SQLException se) {
            throw new DAOException("Error updating employee in DAO", se);
        }
    }

    /**
     * Delete an employee record that has this ID from the database
     * using the DELETE command
     */
    @Override
    public void delete(int id) throws DAOException {
        Employee emp = findById(id);
        if (emp == null) {
            throw new DAOException("Employee id: " + id + " does not exist to delete.");
        }
        try (Statement stmt = con.createStatement()) {
            String query = "DELETE FROM EMPLOYEE WHERE ID=" + id;
            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("Error deleting employee");
            }
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error deleting employee in DAO", se);
        }
    }

    /**
     * Find an Employee record using this ID
     */
    @Override
    public Employee findById(int id) throws DAOException {
        try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM EMPLOYEE WHERE ID=" + id;
            ResultSet rs = stmt.executeQuery(query);
            if (!rs.next()) {
                return null;
            }
            return (new Employee(rs.getInt("ID"), rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"), rs.getDate("BIRTHDATE"),
                    rs.getFloat("SALARY")));
        } catch (SQLException se) {
            throw new DAOException("Error finding employee in DAO", se);
        }
    }

    /**
     * Return an array of all of the Employee records
     * We are using a collection List object to store the results
     * This makes it easier to just add to the collection
     */
    @Override
    public Employee[] getAllEmployees() throws DAOException {
        try (Statement stmt = con.createStatement()) {

            String query = "SELECT * FROM EMPLOYEE";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Employee> emps = new ArrayList<>();

            while (rs.next()) {
                emps.add(new Employee(
                        rs.getInt("ID"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getDate("BIRTHDATE"),
                        rs.getFloat("SALARY")));
            }
            return emps.toArray(new Employee[0]);
        } catch (SQLException se) {
            throw new DAOException("Error getting all employees in DAO: " +
                    se.getMessage(), se);
        }
    }

    @Override
    public void close() throws Exception {
        try {
            con.close();
        } catch (SQLException se) {
            System.out.println("Exception closing Connection: " + se);
        }
    }
}