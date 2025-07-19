package com.igorbavand.subititlegenerator.dto.gemini.dto

import com.igorbavand.subititlegenerator.dto.gemini.request.GeminiPart

data class GeminiContent(
    val parts: List<GeminiPart>,
    val role: String = "user"
)