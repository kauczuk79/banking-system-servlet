package com.gft.banking.dal.converters;

import com.gft.banking.dal.dto.AccountServiceDTO;
import com.gft.banking.dal.entities.AccountEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class AccountEntityConverter implements IEntityConverter<AccountEntity, AccountServiceDTO> {
    @Override
    public AccountServiceDTO convert(AccountEntity entity) throws InvocationTargetException, IllegalAccessException {
        final AccountServiceDTO account = new AccountServiceDTO();
        BeanUtils.copyProperties(account, entity);
        return account;
    }
}
