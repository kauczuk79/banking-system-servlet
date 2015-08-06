package com.gft.banking.dal.converters;

import com.gft.banking.dal.dto.TransactionServiceDTO;
import com.gft.banking.dal.entities.TransactionEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class TransactionEntityConverter implements IEntityConverter<TransactionEntity, TransactionServiceDTO> {
    @Override
    public TransactionServiceDTO convert(TransactionEntity entity) throws InvocationTargetException, IllegalAccessException {
        final TransactionServiceDTO transaction = new TransactionServiceDTO();
        BeanUtils.copyProperties(transaction, entity);
        return transaction;
    }
}
