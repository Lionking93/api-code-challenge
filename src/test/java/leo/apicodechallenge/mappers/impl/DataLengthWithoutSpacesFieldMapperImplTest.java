/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leo.apicodechallenge.mappers.impl;

import leo.apicodechallenge.data.AnalyzeRequest;
import leo.apicodechallenge.data.AnalyzeResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Omistaja
 */
public class DataLengthWithoutSpacesFieldMapperImplTest {
    private final DataLengthWithoutSpacesFieldMapperImpl mapper = new DataLengthWithoutSpacesFieldMapperImpl(); 
    private AnalyzeRequest request;
    private AnalyzeResponse response;
    
    @BeforeEach
    public void init() {
        this.request = new AnalyzeRequest();
        this.response = new AnalyzeResponse();
    }
    
    @Test
    public void lengthWithoutSpacesIsReturnedCorrectlyIfTextIsNotEmpty() {
        this.request.setText("hello 2 times  ");
        this.mapper.map(this.request, this.response);
        assertEquals(11, this.response.getTextLength().getWithoutSpaces());
    }
    
    @Test
    public void lengthWithoutSpacesIsReturnedCorrectlyIfTextIsEmpty() {
        this.request.setText("");
        this.mapper.map(this.request, this.response);
        assertEquals(0, this.response.getTextLength().getWithoutSpaces());
    }
    
    @Test
    public void lengthWithoutSpacesIsReturnedCorrectlyIfTextIsNull() {
        this.mapper.map(this.request, this.response);
        assertEquals(0, this.response.getTextLength().getWithoutSpaces());
    }
}
