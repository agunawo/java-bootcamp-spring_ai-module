package com.accenture.springai_bootcamp_demo.controller;

import com.accenture.springai_bootcamp_demo.dto.SummarizeRequest;
import com.accenture.springai_bootcamp_demo.dto.SummarizeResponse;
import com.accenture.springai_bootcamp_demo.service.AiToolService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * My own LLM use case endpoint (M13): one-shot text summarization via the
 * local Ollama model. Separate from the chat API on purpose — it is a
 * bounded, stateless tool rather than a conversation.
 */
@RestController
@RequestMapping("/api/tools")
@AllArgsConstructor
public class ToolController {

    private final AiToolService aiToolService;

    @PostMapping("/summarize")
    public SummarizeResponse summarize(@Valid @RequestBody SummarizeRequest request) {
        return new SummarizeResponse(aiToolService.summarize(request.text()));
    }
}
