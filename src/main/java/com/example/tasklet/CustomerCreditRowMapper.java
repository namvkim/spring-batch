package com.example.tasklet;

import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerCreditRowMapper implements RowMapper<Product> {

    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String PRICE_COLUMN = "price";

    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product customerCredit = new Product();

        customerCredit.setId(rs.getLong(ID_COLUMN));
        customerCredit.setName(rs.getString(NAME_COLUMN));
        customerCredit.setPrice(rs.getLong(PRICE_COLUMN));

        return customerCredit;
    }
}
