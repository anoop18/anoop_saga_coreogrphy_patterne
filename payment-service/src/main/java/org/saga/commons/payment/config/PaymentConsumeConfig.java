package org.saga.commons.payment.config;

import org.reactivestreams.Publisher;
import org.saga.commons.event.OrderEvent;
import org.saga.commons.event.OrderStatus;
import org.saga.commons.event.PaymentEvent;
import org.saga.commons.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;
import java.util.function.Function;

@Configuration
public class PaymentConsumeConfig {

    @Autowired
    private PaymentService paymentService;
@Bean
    public Function<Flux<OrderEvent>,Flux<PaymentEvent>> paymentProcessor(){
        return orderEventFlux -> orderEventFlux.flatMap(this::processPayment);
    }

    private Mono<PaymentEvent> processPayment(OrderEvent orderEvent) {
    // get the userId
        //check the balance availability
        //if balance sufficient -> Payment Completed and deduct amount from DB
        //if payment not sufficient -> cancel order event and update the amount  in DB
   if(OrderStatus.ORDER_CREATED.equals(orderEvent.getOrderStatus())){
       return Mono.fromSupplier(()->this.paymentService.newOrderEvent(orderEvent));
   }else {
       return Mono.fromSupplier(()->this.paymentService.cancelOrderEvent(orderEvent));
   }

    }


}
