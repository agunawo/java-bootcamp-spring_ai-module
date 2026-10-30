package com.accenture.springai_bootcamp_demo.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * Request body for the summarize use case: the text to shorten.
 */
public record SummarizeRequest(@NotBlank String text) {
}
