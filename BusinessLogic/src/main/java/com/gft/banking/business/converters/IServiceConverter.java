package com.gft.banking.business.converters;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public interface IServiceConverter<I, O> {
    O convert(final I serviceDto) throws InvocationTargetException, IllegalAccessException;
}
