package pl.edu.amu.wmi.students.mario.bif.zad1

import pl.edu.amu.wmi.students.mario.bif.zad1.CryptoBox.hash

fun main(args: Array<String>) {
    val (firstWord, secondWord) = FloydAlgorithm.findCollision(::hash)
    println("Collision:")
    println(firstWord + " -> " + hash(firstWord))
    println(secondWord + " -> " + hash(secondWord))
}