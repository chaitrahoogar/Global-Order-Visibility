package com.hashworks.GobalOrderVisibility.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by harshitha on 7/7/17.
 */
@Entity
@Table(name="business_unit")
public class BusinessUnit {

    @Id
    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private String businessUnitName;

    @Override
    public String toString() {
        return "BusinessUnit{" +
                "id=" + id +
                ", businessUnitName='" + businessUnitName + '\'' +
                '}';
    }
}
