package com.transactionservice.util;

import com.transactionservice.dto.UserAccountDto;
import com.transactionservice.dto.UserTransactionDto;
import com.transactionservice.entity.UserAccount;
import com.transactionservice.entity.UserTransaction;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

@UtilityClass
public class MapperUtil {

    public UserAccountDto toDto(UserAccount userAccount) {
        UserAccountDto userAccountDto = new UserAccountDto();
        BeanUtils.copyProperties(userAccount,userAccountDto);
        return userAccountDto;
    }

    public UserAccount toEntity(UserAccountDto userAccountDto) {
        UserAccount userAccount = new UserAccount();
        BeanUtils.copyProperties(userAccountDto,userAccount);
        return userAccount;
    }

    public UserTransactionDto toDto(UserTransaction userTransaction) {
        UserTransactionDto userTransactionDto = new UserTransactionDto();
        BeanUtils.copyProperties(userTransaction, userTransactionDto);
        userTransactionDto.setUserId(userTransaction.getUserAccountId());
        return userTransactionDto;
    }

    public UserTransaction toEntity(UserTransactionDto userTransactionDto) {
        UserTransaction userTransaction = new UserTransaction();
        BeanUtils.copyProperties(userTransactionDto, userTransaction);
        UserAccount userAccount = new UserAccount();
       // userTransaction.setUserAccountId(userAccount);
        return userTransaction;
    }

}
