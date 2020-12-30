package Model;


import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EmployeeDao extends GenericDao<Employee, Integer> {
    public EmployeeDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getentityClass() {
        return Employee.class;
    }

    public Double MostSalary(){
        TypedQuery<Employee> query=super.entityManager.createQuery("select emp from Employee emp where emp.salary=(select max (salary) from Employee)",Employee.class);

        return query.getSingleResult().getSalary();
    }
    public Employee loadByMostSalary(){
        TypedQuery<Employee> query=super.entityManager.createQuery("select emp from Employee emp where emp.salary=(select max (salary) from Employee)",Employee.class);

        return query.getSingleResult();
    }

}
