package ch.diso.ex04;

public interface EmployeeDAO extends AutoCloseable {

    void add(Employee emp);

    void update(Employee emp);

    void delete(int id);

    Employee findById(int id);

    Employee[] getAllEmployees();

}