/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leo.apicodechallenge.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Omistaja
 */
public class AnalyzeResponse {
    private final TextLengths textLength = new TextLengths();
    private int wordCount;
    private List<Map> characterCount = new ArrayList<>();
    
    public TextLengths getTextLength() {
        return this.textLength;
    }
    
    public int getWordCount() {
        return this.wordCount;
    }
    
    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }
    
    public List<Map> getCharacterCount() {
        return this.characterCount;
    }
    
    public void setCharacterCount(List<Map> characterCount) {
        this.characterCount = characterCount;
    }
    
    public void setTextLengthWithSpaces(int textLengthWithSpaces) {
        this.textLength.setWithSpaces(textLengthWithSpaces);
    }
        
    public void setTextLengthWithoutSpaces(int textLengthWithoutSpaces) {
        this.textLength.setWithoutSpaces(textLengthWithoutSpaces);
    }
}
