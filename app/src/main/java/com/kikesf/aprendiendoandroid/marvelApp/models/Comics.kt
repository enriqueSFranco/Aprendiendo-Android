package com.kikesf.aprendiendoandroid.marvelApp.models

data class Comics(
    val available: Long,
    val collectionURI: String,
    val items: List<ComicsItem>,
    val returned: Long
)
