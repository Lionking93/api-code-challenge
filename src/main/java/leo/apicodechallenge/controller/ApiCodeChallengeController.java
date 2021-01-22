/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leo.apicodechallenge.controller;

import leo.apicodechallenge.data.AnalyzeRequest;
import leo.apicodechallenge.data.AnalyzeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import leo.apicodechallenge.mappers.RequestResponseMapper;

/**
 *
 * @author Omistaja
 */
@RestController
public class ApiCodeChallengeController {
    
    @Autowired
    private RequestResponseMapper<AnalyzeRequest, AnalyzeResponse> requestAnalyzer;
    
    @RequestMapping(value="/analyze", method=RequestMethod.POST)
    public AnalyzeResponse analyzeText(@RequestBody AnalyzeRequest request) {
        System.out.println("Request: " + request.getText());
        AnalyzeResponse response = new AnalyzeResponse();
        requestAnalyzer.map(request, response);
        return response;
    }
}
