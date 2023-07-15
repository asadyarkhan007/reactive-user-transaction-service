package com.transactionservice.controller;

import com.transactionservice.dto.UserAccountDto;
import com.transactionservice.dto.UserTransactionDto;
import com.transactionservice.service.UserAccountService;
import com.transactionservice.service.UserTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserAccountService userAccountService;

    @Autowired
    UserTransactionService userTransactionService;

    @GetMapping
    public Flux<UserAccountDto> getAll() {
        return userAccountService.findAll();
    }

    @GetMapping("/{userId}/transactions")
    public Flux<UserTransactionDto> getAllTransactions(@PathVariable int userId) {
        return userTransactionService.findByUserId(userId);
    }

    @PostMapping("/{userId}/transactions")
    public Mono<UserTransactionDto> createTransaction(@PathVariable int userId, @RequestBody Mono<UserTransactionDto> userTransactionDto) {
        return userTransactionService.create(userId, userTransactionDto);
    }

    @GetMapping("/{userId}/transactions/{transId}")
    public Mono<UserTransactionDto> getAllTransactionsById(@PathVariable int userId, @PathVariable int transId) {
        return userTransactionService.findAllByUserIdAndTransId(userId,transId);
    }

    @GetMapping("/{id}")
    public Mono<UserAccountDto> findById(@PathVariable int id) {
        return userAccountService.findOne(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable int id) {
        return userAccountService.delete(id);
    }

    @PostMapping
    public Mono<UserAccountDto> insert(@RequestBody Mono<UserAccountDto> userAccountDto) {
        return userAccountService.create(userAccountDto);
    }

    @PutMapping("/{id}")
    public Mono<UserAccountDto> update(@PathVariable int id, @RequestBody Mono<UserAccountDto> userAccountDto) {
        return userAccountService.update(id, userAccountDto);
    }


}
