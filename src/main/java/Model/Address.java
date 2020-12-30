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
    @OneToMany(mappedBy = "address")
    private Set<PhoneNumber> phoneNumbers;

}
