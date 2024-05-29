package org.saga.commons.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.saga.commons.dto.OrderRequestDto;

import java.util.Date;
import java.util.UUID;
@NoArgsConstructor
@Data
public class OrderEvent implements Event {

    private UUID eventId= UUID.randomUUID();
    private Date eventDate= new Date();
    private OrderRequestDto orderRequestDto;
    private OrderStatus orderStatus;


    @Override
    public Date getDate() {
        return eventDate;
    }
    @Override
    public UUID getEventId() {
        return eventId;
    }

    public OrderEvent(OrderRequestDto orderRequestDto, OrderStatus orderStatus) {
        this.orderRequestDto = orderRequestDto;
        this.orderStatus = orderStatus;
    }
}
