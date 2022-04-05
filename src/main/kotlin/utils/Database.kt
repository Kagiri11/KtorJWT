package utils

import models.user.User
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

object Database {
    private val client = KMongo.createClient().coroutine
    private val database = client.getDatabase("my_Database")
    val usersCollection = database.getCollection<User>()
}