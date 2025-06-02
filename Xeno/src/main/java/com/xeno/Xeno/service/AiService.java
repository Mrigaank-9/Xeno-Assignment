package com.xeno.Xeno.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class AiService {

    @Value("${huggingface.api.key}")
    private String huggingFaceApiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String analyzeSentiment(String text) {
        String url = "https://api-inference.huggingface.co/models/distilbert-base-uncased-finetuned-sst-2-english";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(huggingFaceApiKey);

        Map<String, String> body = new HashMap<>();
        body.put("inputs", text);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        return response.getBody();
    }
}
