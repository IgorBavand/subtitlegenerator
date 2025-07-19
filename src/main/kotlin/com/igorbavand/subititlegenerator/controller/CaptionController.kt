package com.igorbavand.subititlegenerator.controller

import com.igorbavand.subititlegenerator.dto.CaptionRequest
import com.igorbavand.subititlegenerator.enums.PlatformEnum
import com.igorbavand.subititlegenerator.enums.ToneEnum
import com.igorbavand.subititlegenerator.service.CaptionService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/caption")
class CaptionController(
    private val captionService: CaptionService
) {

    @PostMapping(consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun generateCaption(
        @RequestParam image: MultipartFile,
        @RequestParam tone: ToneEnum,
        @RequestParam platform: PlatformEnum,
    ): ResponseEntity<String> {

        val request = CaptionRequest(tone, platform)

        val caption = captionService.generateCaption(image, request)
        return ResponseEntity.ok(caption)
    }
}