package com.yt8492.hellompp.common

expect val greetingMessage: String

fun getGreetingMessage(): String = greetingMessage