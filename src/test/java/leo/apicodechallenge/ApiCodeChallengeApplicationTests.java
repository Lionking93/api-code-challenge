package leo.apicodechallenge;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import leo.apicodechallenge.data.AnalyzeRequest;
import leo.apicodechallenge.data.AnalyzeResponse;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiCodeChallengeApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void shouldReturnAnalyseResponse() throws JsonProcessingException, Exception {
        ObjectMapper mapper = new ObjectMapper();
        AnalyzeRequest request = new AnalyzeRequest();
        request.setText("hello 2 times");
        String jsonContent = mapper.writeValueAsString(request);
        
        String expectedResponse = createExpectedResponseJson();
        
        this.mockMvc.perform(
                post("/analyze")
                    .content(jsonContent)
                    .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().string(containsString(expectedResponse)));
    }

    private String createExpectedResponseJson() throws JsonProcessingException {
        AnalyzeResponse expectedResponse = new AnalyzeResponse();
        expectedResponse.setTextLengthWithSpaces(13);
        expectedResponse.setTextLengthWithoutSpaces(11);
        
        List<Map> charCountList = new ArrayList();
        addCharacterCountToList(charCountList, 'e', 2);
        addCharacterCountToList(charCountList, 'h', 1);
        addCharacterCountToList(charCountList, 'i', 1);
        addCharacterCountToList(charCountList, 'l', 2);
        addCharacterCountToList(charCountList, 'm', 1);
        addCharacterCountToList(charCountList, 'o', 1);
        addCharacterCountToList(charCountList, 's', 1);
        addCharacterCountToList(charCountList, 't', 1);
        
        expectedResponse.setCharacterCount(charCountList);
        expectedResponse.setWordCount(3);
        
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(expectedResponse);
    }
    
    private void addCharacterCountToList(List charCountList, char c, int count) {
        Map<Character, Integer> charCount = new HashMap();
        charCount.put(c, count);
        charCountList.add(charCount);
    }
}
