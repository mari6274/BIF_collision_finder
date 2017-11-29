package pl.edu.amu.wmi.students.mario.bif.zad1

import java.util.*

object FloydAlgorithm : CollisionFindStrategy {
    override fun findCollision(hashFunction: (String) -> String): Pair<String, String> {
        val startWord = UUID.randomUUID().toString()

        var tortoise = hashFunction(startWord)
        var hare = hashFunction(hashFunction(startWord))

        while (tortoise != hare) {
            tortoise = hashFunction(tortoise)
            hare = hashFunction(hashFunction(hare))
        }

        tortoise = startWord

        var tortoiseLastWord = ""
        var hareLastWord = ""

        while (tortoise != hare) {
            tortoise = hashFunction(tortoise)
            hare = hashFunction(hare)

            if (tortoise != hare) {
                tortoiseLastWord = tortoise
                hareLastWord = hare
            } else {
                return Pair(tortoiseLastWord, hareLastWord)
            }
        }

        throw IllegalStateException()
    }
}