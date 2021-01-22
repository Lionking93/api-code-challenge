/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leo.apicodechallenge.configuration;

import leo.apicodechallenge.mappers.RequestResponseMapper;
import leo.apicodechallenge.helpers.RequestResponseMapperImplBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Omistaja
 */
@Configuration
public class ApiCodeChallengeConfiguration {
    @Bean
    public RequestResponseMapper requestResponseMapper() {
        return new RequestResponseMapperImplBuilder()
                .addDataLengthWithSpacesMapper()
                .addDataLengthWithoutSpacesMapper()
                .addDataWordCountMapper()
                .addDataCharacterCountMapper()
                .build();
    }
}
