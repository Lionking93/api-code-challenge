/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leo.apicodechallenge.mappers.impl;

import java.util.ArrayList;
import java.util.List;
import leo.apicodechallenge.data.AnalyzeRequest;
import leo.apicodechallenge.data.AnalyzeResponse;
import leo.apicodechallenge.mappers.RequestResponseMapper;
/**
 *
 * @author Omistaja
 */
public class RequestResponseMapperImpl implements RequestResponseMapper<AnalyzeRequest, AnalyzeResponse> {
    private final List<RequestResponseMapper> dataMappers = new ArrayList();

    public List<RequestResponseMapper> getDataMappers() {
        return this.dataMappers;
    }
    
    @Override
    public void map(AnalyzeRequest requestData, AnalyzeResponse responseData) {   
        for (RequestResponseMapper mapper : dataMappers) {
            mapper.map(requestData, responseData);
        }
    }
    
}
