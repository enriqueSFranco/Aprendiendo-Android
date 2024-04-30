package com.kikesf.aprendiendoandroid.marvelApp.models

enum class Type(val value: String) {
    Cover("cover"),
    Empty(""),
    InteriorStory("interiorStory");

    companion object {
        public fun fromValue(value: String): Type = when (value) {
            "cover" -> Cover
            "" -> Empty
            "interiorStory" -> InteriorStory
            else -> throw IllegalArgumentException()
        }
    }
}
