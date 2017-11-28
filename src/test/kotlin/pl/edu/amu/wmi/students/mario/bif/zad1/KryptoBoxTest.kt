package pl.edu.amu.wmi.students.mario.bif.zad1

import org.junit.Assert.assertEquals
import org.junit.Test

class KryptoBoxTest {

    private val cryptoBox = CryptoBox

    @Test
    fun testMd5() {
        assertEquals("0x66597ea2e4fe91a8747a022900f63b51", cryptoBox.md5(cryptoBox.md5("renmich1123376350383621786626".toByteArray())).hexString())
        assertEquals("0x66597ea2e4fe91a874da5d0d27dfc4e3", cryptoBox.md5(cryptoBox.md5("renmich3700873222361195459231".toByteArray())).hexString())
    }

    @Test
    fun testHex() {
        assertEquals("0x72656e6d696368", "renmich".toByteArray().hexString())
    }

    @Test
    fun collisionLength() {
        assertEquals(0, cryptoBox.collisionLength("1234567890", "1234567890"))
        assertEquals(1, cryptoBox.collisionLength("1234x67890", "1234567890"))
        assertEquals(10, cryptoBox.collisionLength("xxxxxxxxxx", "1234567890"))
    }

}