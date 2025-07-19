package com.igorbavand.subititlegenerator.service

import com.igorbavand.subititlegenerator.client.GeminiClient
import com.igorbavand.subititlegenerator.dto.CaptionRequest
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Service
class CaptionService(
    private val geminiClient: GeminiClient
) {

    fun generateCaption(image: MultipartFile, metadata: CaptionRequest): String {
        val imageBase64 = Base64.getEncoder().encodeToString(image.bytes)

        val prompt = """
            Gere uma legenda pronta para ser postada em ${metadata.platform}, com o tom "${metadata.tone}".
            
            A legenda deve conter:
            - Um texto principal criativo e envolvente, com até 280 caracteres (se necessário, adapte ao limite da plataforma).
            - Hashtags relevantes separadas e agrupadas ao final da legenda e com quebra de linha antes delas.
            - Emojis se forem apropriados ao tom e à plataforma.
            
            Responda com apenas a legenda final, pronta para ser copiada e colada — sem explicações, listas ou variações.
        """.trimIndent()



        return geminiClient.generateCaption(imageBase64, prompt)
    }
}


