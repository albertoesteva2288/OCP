package ch.diso.ex12_JDBC;

import ch.diso.ex04.EmployeeDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmployeeTest extends ch.diso.ex04.EmployeeTest {

    public static void main(String[] args) {

        EmployeeDAOFactory factory = new EmployeeDAOFactory();

        boolean timeToQuit = false;
        try (EmployeeDAO dao = factory.createEmployeeDAO();
             BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                try {
                    timeToQuit = executeMenu(in, dao);
                } catch (DAOException e) {
                    System.out.println("Error " + e.getClass().getName());
                    System.out.println("Message: " + e.getMessage());
                }
            } while (!timeToQuit);
        } catch (IOException e) {
            System.out.println("Error " + e.getClass().getName() + " , quiting.");
            System.out.println("Message: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error closing resource " + e.getClass().getName());
            System.out.println("Message: " + e.getMessage());
        }
    }

}