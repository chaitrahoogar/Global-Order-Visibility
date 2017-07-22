package com.hashworks.GobalOrderVisibility.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by harshitha on 7/7/17.
 */
@Entity
@Table(name = "track_order")
public class TrackOrder {

    @Id
    @Setter
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trackOrderId;

    @Setter
    @Getter
    @OneToOne
    @JoinColumn(name="order_details_id")
  //  @JoinTable(name= "order_detail")
    private OrderDetails orderDetails;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name="region_id")
  //  @JoinTable(name = "region")
    private Region region;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name="business_unit_id")
    private BusinessUnit businessUnit;

    @Setter
    @Getter
    @ManyToOne
  // @JoinTable(name = "lob")
    @JoinColumn(name="lob_id")
    private LOB lob;

    @Setter
    @Getter
    /*@GeneratedValue(strategy = GenerationType.AUTO)
    @ManyToOne
    @JoinColumn(name="tie_number_id")*/
    private Long tieNumber;

    @Override
    public String toString() {
        return "TrackOrder{" +
                "trackOrderId=" + trackOrderId +
                ", orderDetails=" + orderDetails +
                ", region=" + region +
                ", businessUnit=" + businessUnit +
                ", lob=" + lob +
                ", tieNumber=" + tieNumber +
                '}';
    }
}
