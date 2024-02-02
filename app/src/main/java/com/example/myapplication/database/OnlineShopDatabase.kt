package com.example.myapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.dao.OwnerDao
import com.example.myapplication.entities.Owner

@Database(entities = [Owner::class], version = 1)
abstract class OnlineShopDatabase: RoomDatabase() {
    abstract fun ownerDao(): OwnerDao
}