package Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mk_Address")
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "city")
    private String city;
    @Column(name = "postaladdress")
    private String postalAddress;
    @Column(name = "postalcode")
    private Integer postalCode;
    @OneToMany(mappedBy = "address",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<PhoneNumber> phoneNumbers;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "fk_Employee")
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
