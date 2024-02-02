package com.example.myapplication.repository

import android.content.Context
import androidx.room.Room
import com.example.myapplication.database.OnlineShopDatabase
import com.example.myapplication.entities.Owner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OwnerRepository {

    companion object {
        private const val ONLINESHOP_DB = "onlineshop.db"

        @Volatile
        private var INSTANCE: OnlineShopDatabase? = null

        fun getInstance(context: Context): OnlineShopDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also {
                INSTANCE = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context, OnlineShopDatabase::class.java, ONLINESHOP_DB
        ).build()
    }

    suspend fun getOwners(context: Context): List<Owner> {
        val db = getInstance(context)
        lateinit var ownerList: List<Owner>

        withContext(Dispatchers.IO) {
            try {
                ownerList = db.ownerDao().getOwners()
            } catch (e: Exception) {
                println("Failed to get owner list ${e.message}")
            }
        }
        return ownerList
    }

   suspend fun addOwner(context: Context, owner: Owner) {
        val db = getInstance(context)
        withContext(Dispatchers.IO) {
            try {
                db.ownerDao().insertOwner(owner)
                println("Added")
            } catch (e: Exception) {
                println("Failed to add owner ${e.message}")
            }
        }
    }

    suspend fun updateOwner(context: Context, owner: Owner) {
        val db = getInstance(context)
        withContext(Dispatchers.IO) {
            try {
                db.ownerDao().editOwner(owner)
                println("Updated")
            } catch (e: Exception) {
                println("Failed to update owner ${e.message}")
            }
        }
    }

    suspend fun deleteOwner(context: Context, owner: Owner) {
        val db = getInstance(context)
        withContext(Dispatchers.IO) {
            try {
                db.ownerDao().deleteOwner(owner)
                println("Deleted")
            } catch (e: Exception) {
                println("Failed to Delete owner ${e.message}")
            }
        }
    }
}