package com.example.hashing

import java.security.MessageDigest
import javax.xml.bind.DatatypeConverter

/**
 * @see <a href="https://www.md5hashgenerator.com">MD5 Hash Generator</a>
 */
fun main() {
    val planText = "password1!2@3#"
    val md = MessageDigest.getInstance("MD5")
    md.update(planText.toByteArray())

    val digest = DatatypeConverter.printHexBinary(md.digest())
    println("planText: ${planText}")
    println("MD5 encoding result: ${digest}")
}
