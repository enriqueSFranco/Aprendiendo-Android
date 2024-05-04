package com.kikesf.aprendiendoandroid.marvelApp.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {
    companion object {
        const val BASE_URL = "https://gateway.marvel.com"
        const val PUBLIC_KEY = "1342ee46b3a8207e80b268dc4b8f97a1"
        const val PRIVATE_KEY = "e591b2d38c75b736f8441d4577ae5fc8706ce7e9"
        val timestamp = Timestamp(System.currentTimeMillis()).time.toString()
        fun hash(): String {
            val input = "$timestamp$PRIVATE_KEY$PUBLIC_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }
    }
}


// https://gateway.marvel.com/v1/public/characters?name=thor&ts=1&apikey=1342ee46b3a8207e80b268dc4b8f97a1&hash=e7538208ae63bf14cfdf1c6e4ecded44