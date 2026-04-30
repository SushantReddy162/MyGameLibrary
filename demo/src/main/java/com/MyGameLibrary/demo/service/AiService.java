package com.MyGameLibrary.demo.service;


import com.MyGameLibrary.demo.entities.Game;
import com.MyGameLibrary.demo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AiService {

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    @Autowired
    private GameRepository gameRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    public String chat(String message) {
        List<Game> games = gameRepository.findAll();

        String prompt = "You are a helpful game recommendation assistant. " +
                "The user has a personal game library with the following games: " +
                games.toString() +
                ". Each game has a name, genre, rating (1-10), and an optional custom note. " +
                "Use this information to give personalized, helpful answers. Keep responses concise and friendly.\n\n" +
                "User question: " + message;
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + geminiApiKey;
        Map<String, Object> requestBody = new HashMap<>();
        Map<String, Object> content = new HashMap<>();
        Map<String, Object> part = new HashMap<>();

        part.put("text", prompt);
        content.put("parts", List.of(part));
        requestBody.put("contents", List.of(content));

        ResponseEntity<Map> response = restTemplate.postForEntity(url, requestBody, Map.class);

        Map body = response.getBody();
        List candidates = (List) body.get("candidates");
        Map candidate = (Map) candidates.get(0);
        Map contentMap = (Map) candidate.get("content");
        List parts = (List) contentMap.get("parts");
        Map firstPart = (Map) parts.get(0);
        return (String) firstPart.get("text");
    }
}
