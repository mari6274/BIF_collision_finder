package pl.edu.amu.wmi.students.mario.bif.zad1

import java.math.BigInteger

fun ByteArray.hexString(): String = "0x" + BigInteger(this).toString(16)