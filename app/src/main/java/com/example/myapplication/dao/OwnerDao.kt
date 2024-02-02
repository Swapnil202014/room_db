package com.example.myapplication.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.entities.Owner

@Dao
interface OwnerDao {
    @Insert
    fun insertOwner(owner: Owner)

    @Query("select * from Owner")
    fun getOwners() : List<Owner>

    @Update
    fun editOwner(owner: Owner)

    @Delete
    fun deleteOwner(owner: Owner)
}