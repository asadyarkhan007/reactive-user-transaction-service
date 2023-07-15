package com.transactionservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("user_transaction")
public class UserTransaction {

    @Id
    private int id;
    @Column("user_account_id")
    private int userAccountId;
    @Column
    private double amount;


}
