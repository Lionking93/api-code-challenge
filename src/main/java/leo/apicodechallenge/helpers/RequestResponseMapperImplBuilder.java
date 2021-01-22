/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leo.apicodechallenge.helpers;

import leo.apicodechallenge.mappers.impl.DataLengthWithSpacesFieldMapperImpl;
import leo.apicodechallenge.mappers.impl.DataLengthWithoutSpacesFieldMapperImpl;
import leo.apicodechallenge.mappers.impl.DataWordCountFieldMapperImpl;
import leo.apicodechallenge.mappers.impl.RequestResponseMapperImpl;

/**
 *
 * @author Omistaja
 */
public class RequestResponseMapperImplBuilder {
    private final RequestResponseMapperImpl mapper;
    
    public RequestResponseMapperImplBuilder() {
        this.mapper = new RequestResponseMapperImpl();
    }
    
    public RequestResponseMapperImplBuilder addDataLengthWithSpacesMapper() {
        this.mapper.getDataMappers().add(new DataLengthWithSpacesFieldMapperImpl());
        return this;
    }
    
    public RequestResponseMapperImplBuilder addDataLengthWithoutSpacesMapper() {
        this.mapper.getDataMappers().add(new DataLengthWithoutSpacesFieldMapperImpl());
        return this;
    }
    
    public RequestResponseMapperImplBuilder addDataWordCountMapper() {
        this.mapper.getDataMappers().add(new DataWordCountFieldMapperImpl());
        return this;
    }
    
    public RequestResponseMapperImpl build() {
        return this.mapper;
    }
}
