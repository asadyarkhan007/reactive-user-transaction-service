package com.transactionservice.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("user_account")
public class UserAccount {

    @Id
    private int id;

    @Column
    private String name;

    @Column
    private double balance;
}
