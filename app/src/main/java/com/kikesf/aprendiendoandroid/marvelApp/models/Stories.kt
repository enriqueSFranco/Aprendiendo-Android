package com.kikesf.aprendiendoandroid.marvelApp.models

data class Stories(
    val available: Long,
    val collectionURI: String,
    val items: List<StoriesItem>,
    val returned: Long
)
