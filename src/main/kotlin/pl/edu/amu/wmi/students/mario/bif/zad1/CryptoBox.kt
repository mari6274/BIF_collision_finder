package pl.edu.amu.wmi.students.mario.bif.zad1

import java.security.MessageDigest

object CryptoBox {

    fun md5(input: ByteArray): ByteArray {
        val messageDigest = MessageDigest.getInstance("MD5")
        messageDigest.update(input)
        return messageDigest.digest()
    }

    fun hash(input: String): String = md5(md5(input.toByteArray())).take(7).toByteArray().hexString()

    fun collisionLength(input1: String, input2: String): Int {
        var length = 0
        input1.forEachIndexed { index, c ->
            if (!c.equals(input2[index])) {
                length++
            }
        }
        return length
    }

}