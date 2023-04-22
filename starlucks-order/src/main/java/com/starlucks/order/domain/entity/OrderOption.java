package com.starlucks.order.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "order_option")
@EntityListeners(AuditingEntityListener.class)
public class OrderOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderOptionGroupId;
    private String name;
    private Long price;
    @CreatedDate
    private LocalDateTime createDtm;
    @LastModifiedDate
    private LocalDateTime updateDtm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderOptionGroupId", insertable = false, updatable = false)
    private OrderOptionGroup orderOptionGroup;

    public OrderOption() {
    }

    public Long getId() {
        return id;
    }

    public Long getOrderOptionGroupId() {
        return orderOptionGroupId;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public LocalDateTime getCreateDtm() {
        return createDtm;
    }

    public LocalDateTime getUpdateDtm() {
        return updateDtm;
    }

    public OrderOptionGroup getOrderOptionGroup() {
        return orderOptionGroup;
    }
}
