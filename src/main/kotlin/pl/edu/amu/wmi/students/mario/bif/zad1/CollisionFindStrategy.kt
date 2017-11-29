package pl.edu.amu.wmi.students.mario.bif.zad1

interface CollisionFindStrategy {
    fun findCollision(hashFunction : (String) -> String): Pair<String, String>
}