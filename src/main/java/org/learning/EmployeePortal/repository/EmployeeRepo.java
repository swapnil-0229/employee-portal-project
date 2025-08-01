package org.learning.EmployeePortal.repository;

import org.learning.EmployeePortal.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
//public class EmployeeRepo {
//    @Autowired
//    private JdbcTemplate jdbc;
//
//    // Get list of all employees
//    public List<Employee> getAllEmp() {
//        String query = "select * from employee";
//        return jdbc.query(query, (rs, rowNum) -> new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
//    }
//
//    // Get employee data using emp Id
//    public Employee getEmp(int empId) {
//        String query = "select * from employee where id=" + empId;
//        return jdbc.queryForObject(query, (rs, rowNum) -> new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
//    }
//
//    // Add an employee
//    public boolean addEmp(Employee emp) {
//        String query = "insert into employee (id, name, department, salary) values (?,?,?,?)";
//        int rows = jdbc.update(query, emp.getEmpId(), emp.getName(), emp.getDepartment(), emp.getSalary());
//        System.out.println(rows + " effected!");
//        return rows != 0;
//    }
//
//    // Update an employee data
//    public boolean updateEmp(Employee emp) {
//        StringBuilder query = new StringBuilder("update employee set ");
//
//        List<String> updates = new ArrayList<>();
//        if(emp.getDepartment() != null) updates.add("department = " + emp.getDepartment()) ;
//        if(emp.getName() != null) updates.add("name = " + emp.getName());
//        if(emp.getSalary() != 0) updates.add("salary = " + emp.getSalary());
//
//        if(updates.isEmpty()) return false;
//        for(int i=0; i<updates.size(); i++){
//            query.append(updates.get(i));
//            if(i != updates.size()-1) query.append(',');
//        }
//
//        query.append(" where id = ").append(emp.getEmpId());
//        System.out.println(query);
//        int rows = jdbc.update(query.toString());
//        System.out.println(rows + " effected!");
//        return rows != 0;
//    }
//
//    // delete an employee
//    public boolean deleteEmp(int empId) {
//        String query = "delete from employee where id=" + empId;
//        int rows = jdbc.update(query);
//        System.out.println(rows + " effected!");
//        return rows != 0;
//    }
//}

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
