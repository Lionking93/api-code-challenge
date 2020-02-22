/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leo.apicodechallenge.businesslogic;

import leo.apicodechallenge.data.AnalyzeRequest;
import leo.apicodechallenge.data.AnalyzeResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Omistaja
 */
public class AnalyzerImplTest {
    public AnalyzerImpl analyzer = new AnalyzerImpl();
    
    @Test
    public void lengthWithSpacesIsReturnedCorrectlyIfTextIsNotEmpty() {
        Assert.assertEquals(15, analyzer.getDataLengthWithSpaces("hello 2 times  "));
    }
    
    @Test
    public void lengthWithSpacesIsReturnedCorrectlyIfTextIsEmpty() {
        Assert.assertEquals(0, analyzer.getDataLengthWithSpaces(""));
    }
    
    @Test
    public void lengthWithSpacesIzZeroIfTextIsNull() {
        Assert.assertEquals(0, analyzer.getDataLengthWithSpaces(null));
    }
    
    @Test
    public void lengthWithoutSpacesIsReturnedCorrectlyIfTextIsNotEmpty() {
        Assert.assertEquals(11, analyzer.getDataLengthWithoutSpaces("hello 2 times  "));
    }
    
    @Test
    public void lengthWithoutSpacesIsReturnedCorrectlyIfTextIsEmpty() {
        Assert.assertEquals(0, analyzer.getDataLengthWithoutSpaces(""));
    }
    
    @Test
    public void lengthWithoutSpacesIsReturnedCorrectlyIfTextIsNull() {
        Assert.assertEquals(0, analyzer.getDataLengthWithoutSpaces(null));
    }
    
    @Test
    public void wordCountIsCorrectIfTextIsEmpty() {
        Assert.assertEquals(0, analyzer.getDataWordCount(""));
    }
    
    @Test
    public void wordCountIsCorrectIfTextIsNull() {
        Assert.assertEquals(0, analyzer.getDataWordCount(null));
    }
    
    @Test
    public void wordCountIsCorrectIfTextHasOneWordWithoutSpaces() {
        Assert.assertEquals(1, analyzer.getDataWordCount("hello"));
    }
    
    @Test
    public void wordCountIsCorrectIfTextHasOneWordAndExtraSpaces() {
        Assert.assertEquals(1, analyzer.getDataWordCount("  hello  "));
    }
    
    @Test
    public void wordCountIsCorrectIfTextHasMultipleWordsAndNoExtraSpaces() {
        Assert.assertEquals(3, analyzer.getDataWordCount("hello 2 times"));
    }
    
    @Test
    public void wordCountIsCorrectIfTextHasMultipleWordsAndSpacesInBeginAndEnd() {
        Assert.assertEquals(3, analyzer.getDataWordCount("  hello 2 times  "));
    }
    
    @Test
    public void wordCountIsCorrectIfTextHasSpacesAlsoInTheMiddle() {
        Assert.assertEquals(3, analyzer.getDataWordCount("  hello  2    times    "));
    }
}