package org.saga.commons.payment.repository;

import org.saga.commons.payment.entity.UserBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBalanceRepository  extends JpaRepository<UserBalance,Integer> {
}
