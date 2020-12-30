package Model;

import javax.persistence.*;

@Entity
@Table(name = "mk_PhoneNumber")
public class PhoneNumber {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "telNumber")
    private String telNumber;
    @Column(name = "mobNumber")
    private String mobNumber;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "fk_address",nullable = false)
    private Address address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
