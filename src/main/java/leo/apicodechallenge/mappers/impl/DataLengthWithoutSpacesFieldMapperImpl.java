/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leo.apicodechallenge.mappers.impl;

import leo.apicodechallenge.data.AnalyzeResponse;
import leo.apicodechallenge.mappers.RequestResponseMapper;
import leo.apicodechallenge.data.AnalyzeRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author Omistaja
 */
public class DataLengthWithoutSpacesFieldMapperImpl implements RequestResponseMapper<AnalyzeRequest, AnalyzeResponse> {

    @Override
    public void map(AnalyzeRequest requestData, AnalyzeResponse responseObject) {
        String requestText = requestData.getText();
        responseObject.setTextLengthWithoutSpaces(requestText == null ? 0 : requestText.replace(" ", "").length());
    }
    
}
