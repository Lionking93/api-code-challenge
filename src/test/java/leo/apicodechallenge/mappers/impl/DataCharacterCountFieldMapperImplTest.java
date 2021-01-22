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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author Omistaja
 */
public class DataCharacterCountFieldMapperImplTest {
    private final DataCharacterCountFieldMapperImpl mapper = new DataCharacterCountFieldMapperImpl();
    private AnalyzeRequest request;
    private AnalyzeResponse response;
    
    @BeforeEach
    public void init() {
        this.request = new AnalyzeRequest();
        this.response = new AnalyzeResponse();
    }
    
    @Test
    public void characterCountArrayForNonNullStringIsReturnedWithCorrectContentAndOrder() {
        this.request.setText("hello 2 times");
        this.mapper.map(this.request, this.response);
        List<Map> expectedCharacterCount = new ArrayList();
        addCharacterCountToList(expectedCharacterCount, 'e', 2);
        addCharacterCountToList(expectedCharacterCount, 'h', 1);
        addCharacterCountToList(expectedCharacterCount, 'i', 1);
        addCharacterCountToList(expectedCharacterCount, 'l', 2);
        addCharacterCountToList(expectedCharacterCount, 'm', 1);
        addCharacterCountToList(expectedCharacterCount, 'o', 1);
        addCharacterCountToList(expectedCharacterCount, 's', 1);
        addCharacterCountToList(expectedCharacterCount, 't', 1);
        assertEquals(expectedCharacterCount, this.response.getCharacterCount());
    }
    
    @Test
    public void characterCountIncludesOnlyEnglishLetters() {
        this.request.setText("  hälläväliä123 ");
        this.mapper.map(this.request, this.response);
        List<Map> expectedCharacterCount = new ArrayList();
        addCharacterCountToList(expectedCharacterCount, 'h', 1);
        addCharacterCountToList(expectedCharacterCount, 'i', 1);
        addCharacterCountToList(expectedCharacterCount, 'l', 3);
        addCharacterCountToList(expectedCharacterCount, 'v', 1);
        assertEquals(expectedCharacterCount, this.response.getCharacterCount());
    }
    
    @Test
    public void characterCountIsCaseInsensitive() {
        this.request.setText("TeksTiteSti");
        this.mapper.map(this.request, this.response);
        List<Map> expectedCharacterCount = new ArrayList();
        addCharacterCountToList(expectedCharacterCount, 'e', 2);
        addCharacterCountToList(expectedCharacterCount, 'i', 2);
        addCharacterCountToList(expectedCharacterCount, 'k', 1);
        addCharacterCountToList(expectedCharacterCount, 's', 2);
        addCharacterCountToList(expectedCharacterCount, 't', 4);
        assertEquals(expectedCharacterCount, this.response.getCharacterCount());
    }
    
    @Test
    public void characterCountArrayIsEmptyForEmptyString() {
        this.request.setText("");
        this.mapper.map(this.request, this.response);
        assertTrue(this.response.getCharacterCount().isEmpty());
    }
    
    @Test
    public void characterCountArrayIsEmptyForNullString() {
        this.mapper.map(this.request, this.response);
        assertTrue(this.response.getCharacterCount().isEmpty());
    }
    
    private void addCharacterCountToList(List charCountList, char c, int count) {
        Map<Character, Integer> charCount = new HashMap();
        charCount.put(c, count);
        charCountList.add(charCount);
    }
}
