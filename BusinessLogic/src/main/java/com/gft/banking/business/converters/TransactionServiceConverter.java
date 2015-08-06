package com.gft.banking.business.converters;

import com.gft.banking.business.dto.TransactionDTO;
import com.gft.banking.dal.dto.TransactionServiceDTO;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class TransactionServiceConverter implements  IServiceConverter<TransactionServiceDTO, TransactionDTO> {
    @Override
    public TransactionDTO convert(TransactionServiceDTO serviceDto) throws InvocationTargetException, IllegalAccessException {
        final TransactionDTO transactionDTO = new TransactionDTO();
        BeanUtils.copyProperties(transactionDTO, serviceDto);
        return transactionDTO;
    }
}
