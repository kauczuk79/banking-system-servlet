package com.gft.banking.dal.converters;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public interface IEntityConverter<I, O> {
    O convert(final I input) throws InvocationTargetException, IllegalAccessException;
}
