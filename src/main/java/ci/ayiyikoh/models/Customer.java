package ci.ayiyikoh.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "sq_customer")
    @SequenceGenerator(name = "sq_customer", sequenceName = "sq_customer", allocationSize = 1)
    private Long customerId;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull @Column(unique = true)
    private String phoneNumber;
    @NonNull
    private String emailAdreesse;
    @Nullable
    private String street;
    @Nullable
    private String country;
    @Nullable
    private String city;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Balance> balances;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "debitAccount")
    private List<Transactions> transactionIssued;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "creditAccount")
    private List<Transactions> transactionReceive;

    public Customer(String firstName, String lastName, String phoneNumber, String emailAdreesse, String street, String country, String city) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.phoneNumber=phoneNumber;
        this.emailAdreesse=emailAdreesse;
        this.street=street;
        this.country=country;
        this.city=city;

    }
}
