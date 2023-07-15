package com.transactionservice.repository;

import com.transactionservice.entity.UserTransaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserTransactionRepository extends ReactiveCrudRepository<UserTransaction,Integer> {

    Mono<UserTransaction> findByUserAccountIdAndId(int userId, int transId);

    Flux<UserTransaction> findByUserAccountId(int userId);

}
