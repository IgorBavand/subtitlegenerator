package com.igorbavand.subititlegenerator.dto.gemini.response

import com.igorbavand.subititlegenerator.dto.gemini.dto.GeminiContent

data class Generation(
    val content: GeminiContent
)