package com.hashworks.GobalOrderVisibility.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by harshitha on 7/7/17.
 */
@Entity
@Table(name="lob")
public class LOB {

    @Id
    @Setter
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Setter
    @Getter
    private String lobsName;

    @Override
    public String toString() {
        return "LOB{" +
                "Id=" + Id +
                ", lobsName='" + lobsName + '\'' +
                '}';
    }
}
