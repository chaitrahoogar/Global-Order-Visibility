package com.hashworks.GobalOrderVisibility.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by harshitha on 7/7/17.
 */
@Entity
@Table(name = "order_detail")
public class OrderDetails {

    @Id
    @Setter
    @Getter
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long Id;

    @Setter
    @Getter
    private Long orderNumber;

    @Setter
    @Getter
    private Long customerNumber;

    @Setter
    @Getter
    private Long poNumber;

    @Override
    public String toString() {
        return "OrderDetails{" +
                "Id=" + Id +
                ", orderNumber=" + orderNumber +
                ", customerNumber=" + customerNumber +
                ", poNumber=" + poNumber +
                '}';
    }
}
