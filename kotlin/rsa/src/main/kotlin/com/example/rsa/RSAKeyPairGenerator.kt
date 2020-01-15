package com.example.rsa

import java.io.File
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import java.util.*

class RSAKeyPairGenerator {
    private val privateKey: PrivateKey
    private val publicKey: PublicKey

    init {
        val keyGen = KeyPairGenerator.getInstance("RSA")
        keyGen.initialize(1024)
        val keyPair = keyGen.generateKeyPair()
        this.privateKey = keyPair.private
        this.publicKey = keyPair.public
    }

    fun writeToFile(path: String, key: String) {
        val file = File(path)
        file.parentFile.mkdir();

        file.bufferedWriter().use {
            it.write(key)
        }
    }

    fun getPrivateKey(): PrivateKey {
        return privateKey
    }

    fun getPublicKey(): PublicKey {
        return publicKey
    }
}

fun main() {
    val keyPairGenerator = RSAKeyPairGenerator()
    val publicKey = keyPairGenerator.getPublicKey().encoded
    val privateKey = keyPairGenerator.getPrivateKey().encoded

    val base64PublicKey = Base64.getEncoder().encodeToString(publicKey)
    val base64PrivateKey = Base64.getEncoder().encodeToString(privateKey)

    keyPairGenerator.writeToFile("RSA/publicKey", base64PublicKey)
    keyPairGenerator.writeToFile("RSA/privateKey", base64PrivateKey)

    println("public key: $base64PublicKey")
    println("private key: $base64PrivateKey")
}
