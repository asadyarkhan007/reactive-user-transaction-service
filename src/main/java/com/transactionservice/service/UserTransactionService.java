package com.transactionservice.service;

import com.transactionservice.dto.UserTransactionDto;
import com.transactionservice.repository.UserAccountRepository;
import com.transactionservice.repository.UserTransactionRepository;
import com.transactionservice.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserTransactionService {

    @Autowired
    UserTransactionRepository userTransactionRepository;

    @Autowired
    UserAccountRepository userAccountRepository;

    public Mono<UserTransactionDto> findAllByUserIdAndTransId(int userId,int transId) {
        return userTransactionRepository.findByUserAccountIdAndId(userId, transId).map(MapperUtil::toDto);
    }

    public Flux<UserTransactionDto> findByUserId(int userId) {
        return userTransactionRepository.findByUserAccountId(userId).map(MapperUtil::toDto);
    }

    public Mono<UserTransactionDto> create(int userId, Mono<UserTransactionDto> userTransactionDtoMono) {
        return userTransactionDtoMono.map(MapperUtil::toEntity).doOnNext(t -> t.setUserAccountId(userId))
                .flatMap(userTransactionRepository::save)
                .flatMap(t -> userAccountRepository.findById(userId)
                        .doOnNext(u -> u.setBalance(u.getBalance()- t.getAmount()))
                        .flatMap(u -> userAccountRepository.save(u))
                        .thenReturn(t)
                )
                .map(MapperUtil::toDto);
    }

    public Mono<Void> delete(int id) {
        return userTransactionRepository.deleteById(id);
    }
}
