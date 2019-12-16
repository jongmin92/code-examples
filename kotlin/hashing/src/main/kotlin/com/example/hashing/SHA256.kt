package com.example.hashing

import java.security.MessageDigest
import javax.xml.bind.DatatypeConverter

/**
 * @see <a href="https://www.cleancss.com/sha256-hash-generator/">SHA-256 Hash Generator</a>
 */
fun main() {
    val planText = "password1!2@3#"
    val md = MessageDigest.getInstance("SHA-256")
    md.update(planText.toByteArray())

    val digest = DatatypeConverter.printHexBinary(md.digest())
    println("planText: ${planText}")
    println("SHA-256 encoding result: ${digest}")
}
