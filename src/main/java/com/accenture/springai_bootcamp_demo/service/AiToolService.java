package com.accenture.springai_bootcamp_demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

/**
 * My own LLM use case (M13 "create your own LLM use case").
 * A bounded, single-purpose call to the local Ollama model: summarize text.
 * Uses a dedicated ChatClient with a system instruction so each request is
 * self-contained (no conversation history, unlike the chat flow).
 */
@Service
public class AiToolService {

    private static final String SUMMARIZE_SYSTEM_PROMPT = """
            You are a concise summarizer.
            Summarize the user's text in 1-2 short sentences.
            Output only the summary, with no preamble.
            """;

    private final ChatClient chatClient;

    public AiToolService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String summarize(String text) {
        return chatClient.prompt()
                .system(SUMMARIZE_SYSTEM_PROMPT)
                .user(text)
                .call()
                .content()
                .trim();
    }
}
