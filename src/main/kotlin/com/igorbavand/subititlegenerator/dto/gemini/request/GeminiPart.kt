package com.igorbavand.subititlegenerator.dto.gemini.request

data class GeminiPart(
    val text: String? = null,
    val inline_data: GeminiInlineData? = null
)