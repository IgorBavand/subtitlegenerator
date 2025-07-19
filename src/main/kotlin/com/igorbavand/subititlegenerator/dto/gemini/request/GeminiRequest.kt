package com.igorbavand.subititlegenerator.dto.gemini.request

import com.igorbavand.subititlegenerator.dto.gemini.dto.GeminiContent

data class GeminiRequest(
    val contents: List<GeminiContent>
)