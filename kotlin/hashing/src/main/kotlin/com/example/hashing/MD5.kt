package com.example.hashing

import java.security.MessageDigest
import javax.xml.bind.DatatypeConverter

@ExperimentalStdlibApi
fun main() {
    val password = "password1!2@3#"
    val md = MessageDigest.getInstance("MD5")
    md.update(password.toByteArray())

    val digest = DatatypeConverter.printHexBinary(md.digest())
    println("digest: ${digest}")
}
