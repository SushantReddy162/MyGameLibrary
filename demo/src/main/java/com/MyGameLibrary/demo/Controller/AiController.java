package com.MyGameLibrary.demo.Controller;

import com.MyGameLibrary.demo.DTO.AiRequest;
import com.MyGameLibrary.demo.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Autowired
    AiService aiService;

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody AiRequest request) {
        String response = aiService.chat(request.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
