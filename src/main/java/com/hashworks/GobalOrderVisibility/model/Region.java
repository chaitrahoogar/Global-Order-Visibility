package com.hashworks.GobalOrderVisibility.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.ResourceProperties;


import javax.persistence.*;

/**
 * Created by harshitha on 7/7/17.
 */
@Entity
@Table(name="region")
public class Region {

    @Id
    @Setter
    @Getter
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Setter
    @Getter
    private String regionCode;

    @Setter
    @Getter
    private String regionName;

    @Override
    public String toString() {
        return "Region{" +
                "Id=" + Id +
                ", regionCode='" + regionCode + '\'' +
                ", regionName='" + regionName + '\'' +
                '}';
    }
}
