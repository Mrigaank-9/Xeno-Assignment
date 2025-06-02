package com.xeno.Xeno.controller;

import com.xeno.Xeno.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    @Autowired
    private AiService aiService;

    @PostMapping("/sentiment")
    public String analyzeSentiment(@RequestBody String text) {
        return aiService.analyzeSentiment(text);
    }
}
