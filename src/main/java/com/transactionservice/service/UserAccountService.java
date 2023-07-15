package com.transactionservice.service;

import com.transactionservice.dto.UserAccountDto;
import com.transactionservice.repository.UserAccountRepository;
import com.transactionservice.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserAccountService {

    @Autowired
    UserAccountRepository userAccountRepository;

    public Flux<UserAccountDto> findAll() {
        return userAccountRepository.findAll().map(MapperUtil::toDto);
    }

    public Mono<UserAccountDto> findOne(int id) {
        return userAccountRepository.findById(id).map(MapperUtil::toDto);
    }

    public Mono<UserAccountDto> create(Mono<UserAccountDto> userAccountDtoMono) {
        return userAccountDtoMono.map(MapperUtil::toEntity).log()
                .flatMap(userAccountRepository::save).map(MapperUtil::toDto);
    }

    public Mono<UserAccountDto> update(int id, Mono<UserAccountDto> userAccountDtoMono) {
        return userAccountRepository.findById(id).flatMap(x -> userAccountDtoMono.map(MapperUtil::toEntity).doOnNext(entity -> entity.setId(id)))
                .flatMap(userAccountRepository::save).map(MapperUtil::toDto);
    }

    public Mono<Void> delete(int id) {
        return userAccountRepository.deleteById(id);
    }
}