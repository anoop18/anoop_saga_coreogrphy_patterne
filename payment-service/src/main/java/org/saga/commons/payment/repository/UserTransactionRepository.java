package org.saga.commons.payment.repository;

import org.saga.commons.payment.entity.UserTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTransactionRepository extends JpaRepository<UserTransaction,Integer> {
}
