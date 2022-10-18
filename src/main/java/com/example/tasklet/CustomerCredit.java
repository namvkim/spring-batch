package com.example.tasklet;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CustomerCredit implements Serializable {

    private int id;
    private String name;
    private BigDecimal credit;

    //getters and setters removed for clarity
}
