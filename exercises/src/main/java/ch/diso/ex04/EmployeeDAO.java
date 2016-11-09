package ch.diso.ex04;

public interface EmployeeDAO extends AutoCloseable {

    void add(Employee emp) throws Exception;

    void update(Employee emp) throws Exception;

    void delete(int id) throws Exception;

    Employee findById(int id) throws Exception;

    Employee[] getAllEmployees() throws Exception;

}