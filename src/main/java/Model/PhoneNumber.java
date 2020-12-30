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
}
