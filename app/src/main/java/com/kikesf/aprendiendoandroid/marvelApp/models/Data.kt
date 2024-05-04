package com.kikesf.aprendiendoandroid.marvelApp.models

data class Data(
    val offset: Long,
    val limit: Long,
    val total: Long,
    val count: Long,
    val results: List<Result>
)
