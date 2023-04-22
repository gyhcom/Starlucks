package com.starlucks.order.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "\"order\"")
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long storeId;
    private Long memberId;
    private Long paymentId;
    private Long totalPrice;
    private String status;
    @CreatedDate
    private LocalDateTime createDtm;
    @LastModifiedDate
    private LocalDateTime updateDtm;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderLineItem> orderLineItems = List.of();

    public Order() {
    }

    public Order(long storeId, long memberId, long paymentId, String status) {
        this.storeId = storeId;
        this.memberId = memberId;
        this.paymentId = paymentId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreateDtm() {
        return createDtm;
    }

    public LocalDateTime getUpdateDtm() {
        return updateDtm;
    }

    public List<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }
}
