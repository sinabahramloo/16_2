package Model;


import javax.persistence.EntityManager;

public class EmployeeDao extends GenericDao<Employee, Integer> {
    public EmployeeDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getentityClass() {
        return Employee.class;
    }

}
