package ci.ayiyikoh.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "balance")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Balance implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "phoneNumber", nullable = false)
    @Id
    private Customer customer;
    private Double amount;
}
