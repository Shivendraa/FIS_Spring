package com.fis.springjdbc.employee;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class EmployeeDAOImpl extends JdbcDaoSupport implements IEmployee{

	@Override
	public void insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String sql = "insert into employee values(?,?,?)";
		Object[] args = { employee.getId(), employee.getName(), employee.getSalary() };
		int insertedRows = getJdbcTemplate().update(sql, args);
		System.out.println("Rows Inserted: " + insertedRows);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		String sql = "select * from employee";
		List<Employee> employees = getJdbcTemplate().query(sql, new EmployeeMapper());
		return employees;
	}

	@Override
	public void deleteEmployee(int id) {

		String sql = "delete from employee where id=?";
		Object[] args = { id };
		int deletedRows = getJdbcTemplate().update(sql, args);
		System.out.println("Rows Deleted: " + deletedRows);
	}

	@Override
	public void updateEmployee(Employee employee) {
		String sql = "update employee set name=?, salary=? where id=?";
		Object[] args = { employee.getName(), employee.getSalary(), employee.getId() };
		int updatedRows = getJdbcTemplate().update(sql, args);
		System.out.println("Rows Updated: " + updatedRows);

	}

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "select * from employee where id=?";
		Object[] args = { id };
		Employee employeeById = getJdbcTemplate().queryForObject(sql, args, new EmployeeMapper());
		return employeeById;
	}

	
	
}
