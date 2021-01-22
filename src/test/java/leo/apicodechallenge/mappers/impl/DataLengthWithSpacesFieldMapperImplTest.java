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
public class DataLengthWithSpacesFieldMapperImplTest {
    private final DataLengthWithSpacesFieldMapperImpl mapper = new DataLengthWithSpacesFieldMapperImpl();
    private AnalyzeRequest request;
    private AnalyzeResponse response;
    
    @BeforeEach
    public void init() {
        this.request = new AnalyzeRequest();
        this.response = new AnalyzeResponse();
    }
    
    @Test
    public void lengthWithSpacesIsReturnedCorrectlyIfTextIsNotEmpty() {
        this.request.setText("hello 2 times  ");
        this.mapper.map(this.request, this.response);
        assertEquals(15, this.response.getTextLength().getWithSpaces());
    }
    
    @Test
    public void lengthWithSpacesIsReturnedCorrectlyIfTextIsEmpty() {
        this.request.setText("");
        this.mapper.map(this.request, this.response);
        assertEquals(0, this.response.getTextLength().getWithSpaces());
    }
    
    @Test
    public void lengthWithSpacesIzZeroIfTextIsNull() {
        this.mapper.map(this.request, this.response);
        assertEquals(0, this.response.getTextLength().getWithSpaces());
    }
}
