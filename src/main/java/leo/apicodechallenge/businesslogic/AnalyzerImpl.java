/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leo.apicodechallenge.businesslogic;

import leo.apicodechallenge.data.AnalyzeRequest;
import leo.apicodechallenge.data.AnalyzeResponse;
import org.springframework.stereotype.Service;
/**
 *
 * @author Omistaja
 */
@Service
public class AnalyzerImpl implements Analyzer<AnalyzeRequest, AnalyzeResponse> {
    
    public int getDataLengthWithSpaces(String data) {
        return data == null ? 0 : data.length();
    }
    
    public int getDataLengthWithoutSpaces(String data) {
        return data == null ? 0 : data.replace(" ", "").length();
    }
    
    public int getDataWordCount(String data) {
        if (data == null) {
            return 0;
        }
        
        String dataWithoutSpaces = data.trim();
        
        if (dataWithoutSpaces.length() == 0) {
            return 0;
        }
        
        String[] dataParts = dataWithoutSpaces.split("\\s+");
        
        return dataParts.length;
    }

    @Override
    public AnalyzeResponse process(AnalyzeRequest data) {   
        AnalyzeResponse response = new AnalyzeResponse();
        response.setTextLengthWithSpaces(getDataLengthWithSpaces(data.getText()));
        response.setTextLengthWithoutSpaces(getDataLengthWithoutSpaces(data.getText()));
        return response;
    }
    
}
