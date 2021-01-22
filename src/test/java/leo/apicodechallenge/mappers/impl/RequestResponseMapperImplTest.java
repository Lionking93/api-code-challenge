/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leo.apicodechallenge.mappers.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
                .addDataCharacterCountMapper()
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
        
        List<Map> charCountList = new ArrayList();
        addCharacterCountToList(charCountList, 'e', 2);
        addCharacterCountToList(charCountList, 'h', 1);
        addCharacterCountToList(charCountList, 'i', 1);
        addCharacterCountToList(charCountList, 'l', 2);
        addCharacterCountToList(charCountList, 'm', 1);
        addCharacterCountToList(charCountList, 'o', 1);
        addCharacterCountToList(charCountList, 's', 1);
        addCharacterCountToList(charCountList, 't', 1);
        assertEquals(charCountList, response.getCharacterCount());
    }
    
    private void addCharacterCountToList(List charCountList, char c, int count) {
        Map<Character, Integer> charCount = new HashMap();
        charCount.put(c, count);
        charCountList.add(charCount);
    }
}