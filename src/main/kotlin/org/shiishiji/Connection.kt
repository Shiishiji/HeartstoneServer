package org.shiishiji

import me.liuwj.ktorm.database.Database

class Connection {

    fun getDatabase() : Database {
        return Database.connect(
            url = "jdbc:mysql://localhost:3306/ktorm",
            driver = "com.mysql.jdbc.Driver",
            user = "root",
            password = ""
        )
    }

}