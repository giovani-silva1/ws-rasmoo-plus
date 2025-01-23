package com.client.ws.rasmooplus.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "subscriptions_type")
public class SubscriptionsType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subscriptions_type_id")
    private Long id;

    private String name;

    @Column(name = "access_months")
    private int accessMonths;

    private Double price;

    @Column(name = "product_key")
    private String productKey;



}
