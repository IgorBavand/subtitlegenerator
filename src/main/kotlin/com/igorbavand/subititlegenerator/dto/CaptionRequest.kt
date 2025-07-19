package com.igorbavand.subititlegenerator.dto

import com.igorbavand.subititlegenerator.enums.PlatformEnum
import com.igorbavand.subititlegenerator.enums.ToneEnum

data class CaptionRequest(
    val tone: ToneEnum,
    val platform: PlatformEnum
)