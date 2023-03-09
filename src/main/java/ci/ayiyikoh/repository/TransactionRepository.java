package ci.ayiyikoh.repository;

import ci.ayiyikoh.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {
}
