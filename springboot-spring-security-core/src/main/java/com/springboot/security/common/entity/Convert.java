package com.springboot.security.common.entity;


import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.io.Serializable;


public class Convert implements Serializable {

    private static final long serialVersionUID = 6834906431647353543L;

    public <T> T convert(Class<T> clazz) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(this.getClass(), clazz);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(this, clazz);
    }

    public interface Create {

    }

    public interface Update {

    }
}
