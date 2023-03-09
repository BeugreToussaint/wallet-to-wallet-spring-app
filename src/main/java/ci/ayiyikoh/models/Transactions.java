package ci.ayiyikoh.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transactions implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_transaction")
    @SequenceGenerator(sequenceName = "sq_transaction", name = "sq_transaction", allocationSize = 1)
    private Long transaction;
    @NonNull @Column(unique = true)
    private String refTransaction;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phoneNumber", nullable = false)
    private Customer creditAccount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phoneNumber", nullable = false)
    private Customer debitAccount;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate transactionDate;
    private Double Account;
}
