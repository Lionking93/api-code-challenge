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
public class DataWordCountFieldMapperImplTest {
    private final DataWordCountFieldMapperImpl mapper = new DataWordCountFieldMapperImpl();
    private AnalyzeRequest request;
    private AnalyzeResponse response;
    
    @BeforeEach
    public void init() {
        this.request = new AnalyzeRequest();
        this.response = new AnalyzeResponse();
    }
    
    @Test
    public void wordCountIsCorrectIfTextIsEmpty() {
        this.request.setText("");
        this.mapper.map(this.request, this.response);
        assertEquals(0, this.response.getWordCount());
    }
    
    @Test
    public void wordCountIsCorrectIfTextIsNull() {
        this.mapper.map(this.request, this.response);
        assertEquals(0, this.response.getWordCount());
    }
    
    @Test
    public void wordCountIsCorrectIfTextHasOneWordWithoutSpaces() {
        this.request.setText("hello");
        this.mapper.map(this.request, this.response);
        assertEquals(1, this.response.getWordCount());
    }
    
    @Test
    public void wordCountIsCorrectIfTextHasOneWordAndExtraSpaces() {
        this.request.setText("  hello  ");
        this.mapper.map(this.request, this.response);
        assertEquals(1, this.response.getWordCount());
    }
    
    @Test
    public void wordCountIsCorrectIfTextHasMultipleWordsAndNoExtraSpaces() {
        this.request.setText("hello 2 times");
        this.mapper.map(this.request, this.response);
        assertEquals(3, this.response.getWordCount());
    }
    
    @Test
    public void wordCountIsCorrectIfTextHasMultipleWordsAndSpacesInBeginAndEnd() {
        this.request.setText("  hello 2 times  ");
        this.mapper.map(this.request, this.response);
        assertEquals(3, this.response.getWordCount());
    }
    
    @Test
    public void wordCountIsCorrectIfTextHasSpacesAlsoInTheMiddle() {
        this.request.setText("  hello  2    times    ");
        this.mapper.map(this.request, this.response);
        assertEquals(3, this.response.getWordCount());
    }
}
