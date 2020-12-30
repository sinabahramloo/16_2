package Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mk_Employee")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "empCode")
    private Integer empCode;
    @Column(name = "salary")
    private Double salary;
    @OneToMany(mappedBy = "employee",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<Address> addresses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmpCode() {
        return empCode;
    }

    public void setEmpCode(Integer empCode) {
        this.empCode = empCode;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", empCode=" + empCode +
                ", salary=" + salary +
                ", addresses=" + addresses +
                '}';
    }
}
