package com.transactionservice.repository;

import com.transactionservice.entity.UserAccount;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends ReactiveCrudRepository<UserAccount, Integer> {

}
