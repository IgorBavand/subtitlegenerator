package com.igorbavand.subititlegenerator.client

import com.igorbavand.subititlegenerator.dto.gemini.*
import com.igorbavand.subititlegenerator.dto.gemini.dto.GeminiContent
import com.igorbavand.subititlegenerator.dto.gemini.request.GeminiInlineData
import com.igorbavand.subititlegenerator.dto.gemini.request.GeminiPart
import com.igorbavand.subititlegenerator.dto.gemini.request.GeminiRequest
import com.igorbavand.subititlegenerator.dto.gemini.response.GeminiResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class GeminiClient(
    private val builder: WebClient.Builder,
    @Value("\${gemini.api.url}") private val geminiUrl: String,
    @Value("\${gemini.api.key}") private val apiKey: String
) {

    fun generateCaption(base64Image: String, prompt: String): String {
        val request = GeminiRequest(
            contents = listOf(
                GeminiContent(
                    parts = listOf(
                        GeminiPart(text = prompt),
                        GeminiPart(
                            inline_data = GeminiInlineData(
                                mime_type = "image/jpeg",
                                data = base64Image
                            )
                        )
                    )
                )
            )
        )

        val response = builder.build()
            .post()
            .uri("$geminiUrl?key=$apiKey")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(request)
            .retrieve()
            .bodyToMono(GeminiResponse::class.java)
            .block()

        return response?.candidates?.firstOrNull()?.content?.parts?.firstOrNull()?.text ?: "Legenda não gerada"
    }
}