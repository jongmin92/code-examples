package com.example.rsa

import java.security.KeyFactory
import java.security.PrivateKey
import java.security.PublicKey
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec
import java.util.*
import javax.crypto.Cipher

object RSAUtil {

    private val keyFactory = KeyFactory.getInstance("RSA")

    private fun getPublicKey(base64PublicKey: String): PublicKey {
        val keySpec = X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.toByteArray()))
        return keyFactory.generatePublic(keySpec)
    }

    private fun getPrivateKey(base64PrivateKey: String): PrivateKey {
        val keySpec = PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey.toByteArray()))
        return keyFactory.generatePrivate(keySpec)
    }

    fun encrypt(data: String, base64PublicKey: String): ByteArray {
        val cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(base64PublicKey))

        return cipher.doFinal(data.toByteArray())
    }

    private fun decrypt(data: ByteArray, privateKey: PrivateKey): String {
        val cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")
        cipher.init(Cipher.DECRYPT_MODE, privateKey)

        return String(cipher.doFinal(data))
    }

    fun decrypt(data: String, base64PrivateKey: String): String {
        return decrypt(Base64.getDecoder().decode(data.toByteArray()), getPrivateKey(base64PrivateKey))
    }
}

fun main() {
    val publicKey =
        "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCya66h9+mG6z3/3lSV/IjfXFxH/Y0CPgc+YLIjui5JmbNgPC2EQ4GJPsT0CbxjcMTnrSvyj7JzBbJhzmsTBD+HuKEiQOOlGNhPS0HIDvpk+J4DDyuGoTVHnWkuxNC9+IlbkWZQMWHcQ42VCFJwvduESOhs01vSFQCRBYNzYL54HQIDAQAB"
    val privateKey =
        "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBALJrrqH36YbrPf/eVJX8iN9cXEf9jQI+Bz5gsiO6LkmZs2A8LYRDgYk+xPQJvGNwxOetK/KPsnMFsmHOaxMEP4e4oSJA46UY2E9LQcgO+mT4ngMPK4ahNUedaS7E0L34iVuRZlAxYdxDjZUIUnC924RI6GzTW9IVAJEFg3NgvngdAgMBAAECgYEAmAd/Z03ac/dQ/gxRYPgtHL4Td9hJ5eY6v+EfCahkNpy8Jr1AP5pR70NICXWeS9FURuDdOLNO6AmrpQGBZVPSWQODDXq47CJO4bHMk55DXzPue31jva7Kk7l2ydmm2K6h3s9b+4pkYOtN3f/8tnQsbundqIXI2Uz6E8LP8ksGilUCQQDjZt8sMa9nkZ7RC5SqF8QecMKXErsf5iZroYHt+2HHaakoV+Exy+eXBgREPO7cZMC+BIglTciHFD5grCrdwQBLAkEAyNvgViJI0XUsiLlsg9RHA0DciErEkjzXMd6LcND1KspXFM6y484uN6B07SDeqG1Dyn/C+pQarpt5xER9UEU4NwJBAIiqe7fYyH0rJFKobhlnnSNaS2h2BmYecLrA3xCCwvoQw2wOnLXLwQyfvhKwuDFWkAvjN1uMCtc70F1TO5P4eU8CQGJof8ATqhOdUgVmu4jXPzeT1rib0TVIw7I2M6FBb2zYl9Ok9bZw9OniHodzfEOOzRDwianVWEFGAWGsoKzsTP8CQQDZrzW16AnCQrmr1ENCQoQonEZTAAS5FI1XhfIH4VvGq+yCyYMdB7WtQ0kUS3Qm20VfDhim55NjlZd2BPpPBmxL"

    val text = "Please encrypt this data"

    val encryptedString = Base64.getEncoder().encodeToString(RSAUtil.encrypt(text, publicKey))
    println("encryptedString: $encryptedString")

    val decryptedString = RSAUtil.decrypt(encryptedString, privateKey)
    println("decryptedString: $decryptedString")
}
