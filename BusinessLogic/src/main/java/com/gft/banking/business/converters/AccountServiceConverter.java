package com.gft.banking.business.converters;

import com.gft.banking.business.dto.AccountDTO;
import com.gft.banking.business.dto.TransactionDTO;
import com.gft.banking.dal.converters.TransactionEntityConverter;
import com.gft.banking.dal.dto.AccountServiceDTO;
import com.gft.banking.dal.dto.TransactionServiceDTO;
import com.gft.banking.dal.entities.TransactionEntity;
import com.gft.banking.dal.repositories.TransactionRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class AccountServiceConverter implements IServiceConverter<AccountServiceDTO, AccountDTO> {

    private List<TransactionServiceDTO> convertAccountEntityListToTransactionServiceDTOList(List<TransactionEntity> transactionEntityList) {
        final TransactionEntityConverter transactionEntityConverter = new TransactionEntityConverter();
        final List<TransactionServiceDTO> result = new ArrayList<>();
        CollectionUtils.collect(transactionEntityList, (entity) -> {
            final TransactionEntity en = (TransactionEntity) entity;
            try {
                return transactionEntityConverter.convert(en);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        }, result);
        return result;
    }

    private List<TransactionDTO> convertAccountServiceDTOListToTransactionDTOList(List<TransactionServiceDTO> transactionServiceDTOs) {
        final TransactionServiceConverter transactionServiceConverter = new TransactionServiceConverter();
        final List<TransactionDTO> result = new ArrayList<>();
        CollectionUtils.collect(transactionServiceDTOs, (entity) -> {
            final TransactionServiceDTO en = (TransactionServiceDTO) entity;
            try {
                return transactionServiceConverter.convert(en);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        }, result);
        return result;
    }

    @Override
    public AccountDTO convert(AccountServiceDTO serviceDto) throws InvocationTargetException, IllegalAccessException {
        final AccountDTO accountDTO = new AccountDTO();
        BeanUtils.copyProperties(accountDTO, serviceDto);

        final TransactionRepository transactionRepository = new TransactionRepository();
        final List<TransactionEntity> transactionEntityList = transactionRepository.getTransactionsByAccountId(accountDTO.getAccountId());
        final List<TransactionServiceDTO> transactionServiceDTOs = convertAccountEntityListToTransactionServiceDTOList(transactionEntityList);
        final List<TransactionDTO> transactionDTOs = convertAccountServiceDTOListToTransactionDTOList(transactionServiceDTOs);
        transactionDTOs.forEach(accountDTO::addTransaction);

        return accountDTO;
    }


}
