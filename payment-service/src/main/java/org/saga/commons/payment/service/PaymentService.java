package org.saga.commons.payment.service;

import jakarta.annotation.PostConstruct;
import org.saga.commons.event.OrderEvent;
import org.saga.commons.event.PaymentEvent;
import org.saga.commons.payment.entity.UserBalance;
import org.saga.commons.payment.repository.UserBalanceRepository;
import org.saga.commons.payment.repository.UserTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PaymentService {
    @Autowired
    private UserBalanceRepository userBalanceRepository;
    @Autowired
    private UserTransactionRepository userTransactionRepository;
   @PostConstruct
    public void initUserBalanceInDB(){
       userBalanceRepository.saveAll(Stream.of(new UserBalance(101,5000),
               new UserBalance(102,3000),
               new UserBalance(103,4200),
               new UserBalance(104,2000),
               new UserBalance(105,999)).collect(Collectors.toList()));
   }

    {

    }
//    public PaymentEvent newOrderEvent(OrderEvent orderEvent) {
//    }
//
//    public void cancelOrderEvent(OrderEvent orderEvent) {
//    }
}
