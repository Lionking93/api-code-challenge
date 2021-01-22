/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leo.apicodechallenge.mappers.impl;

import leo.apicodechallenge.data.AnalyzeRequest;
import leo.apicodechallenge.data.AnalyzeResponse;
import leo.apicodechallenge.helpers.RequestResponseMapperImplBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *
 * @author Omistaja
 */
public class RequestResponseMapperImplTest {
    private final RequestResponseMapperImpl mapper = new RequestResponseMapperImplBuilder()
                .addDataLengthWithSpacesMapper()
                .addDataLengthWithoutSpacesMapper()
                .addDataWordCountMapper()
                .build();

    @Test
    public void testThatResponseIsCorrectWithAllMappers() {
        AnalyzeRequest request = new AnalyzeRequest();
        AnalyzeResponse response = new AnalyzeResponse();
        
        request.setText("hello 2 times");
        this.mapper.map(request, response);
        assertEquals(13, response.getTextLength().getWithSpaces());
        assertEquals(11, response.getTextLength().getWithoutSpaces());
        assertEquals(3, response.getWordCount());
    }
}