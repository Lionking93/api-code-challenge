/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leo.apicodechallenge.mappers.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import leo.apicodechallenge.data.AnalyzeRequest;
import leo.apicodechallenge.data.AnalyzeResponse;
import leo.apicodechallenge.mappers.RequestResponseMapper;

/**
 *
 * @author Omistaja
 */
public class DataCharacterCountFieldMapperImpl implements RequestResponseMapper<AnalyzeRequest, AnalyzeResponse> {

    private String getSortedRequestTextInLowerCaseWithoutSpaces(String requestText) {
        char[] requestTextAsCharArray = requestText.replace(" ", "").toLowerCase().toCharArray();
        Arrays.sort(requestTextAsCharArray);
        return new String(requestTextAsCharArray);
    }
    
    private boolean isCharValidEnglishLetter(char c) {
        Pattern pattern = Pattern.compile("[A-Za-z]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("" + c);
        return matcher.find();
    }
    
    private Map getCharCountForCharInString(char charToSearch, String requestText) {
        int startIndex = requestText.indexOf(charToSearch);
        int endIndex = requestText.lastIndexOf(charToSearch);
        Map<Character, Integer> charCount = new HashMap();
        charCount.put(charToSearch, endIndex - startIndex + 1);
        return charCount;
    }
    
    private int getIndexOfNextCharInString(char currentChar, String requestText) {
        int endIndex = requestText.lastIndexOf(currentChar);
        int indexOfNextChar = endIndex + 1;
        
        return indexOfNextChar < requestText.length() ? indexOfNextChar : -1;
    }
    
    private List getCharCountList(String requestText) {
        List<Map> charCountList = new ArrayList();
        
        if (requestText.isEmpty()) {
            return charCountList;
        } 
                
        int indexOfChar = 0;
        
        do {
            char currentChar = requestText.charAt(indexOfChar);

            if (isCharValidEnglishLetter(currentChar)) {
                Map<Character, Integer> charCount = getCharCountForCharInString(currentChar, requestText);
                charCountList.add(charCount);
            }
            
            indexOfChar = getIndexOfNextCharInString(currentChar, requestText);
        } while (indexOfChar != -1);
        
        return charCountList;
    }
    
    @Override
    public void map(AnalyzeRequest requestObject, AnalyzeResponse responseObject) {
        String requestText = requestObject.getText() == null ? "" : requestObject.getText();
        
        requestText = getSortedRequestTextInLowerCaseWithoutSpaces(requestText);
        
        List<Map> charCountList = getCharCountList(requestText);
        
        responseObject.setCharacterCount(charCountList);
    }    
}
