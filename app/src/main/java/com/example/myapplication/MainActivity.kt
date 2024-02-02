package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.entities.Owner
import com.example.myapplication.repository.OwnerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        CoroutineScope(Dispatchers.Main).launch {
//            try {
//                val owner = Owner(4,"swapnil","203")
//                OwnerRepository().addOwner(this@MainActivity, owner)
//            } catch (e: Exception) {
//                println("Failed to add from main activity ${e.message}")
//            }
//        }

        CoroutineScope(Dispatchers.Main).launch {
            try {
                var owners = OwnerRepository().getOwners(this@MainActivity)
                println("List size  ${owners.size}")
            } catch (e: Exception) {
                println("Failed to add from main activity ${e.message}")
            }
        }

//        CoroutineScope(Dispatchers.Main).launch {
//            try {
//                val owner = Owner(1, "kshirsagar", "203")
//                OwnerRepository().updateOwner(this@MainActivity, owner)
//            } catch (e: Exception) {
//                println("Failed to update from main activity ${e.message}")
//            }
//        }

//        CoroutineScope(Dispatchers.Main).launch {
//            try {
//                val owner = Owner(4, "swapnil", "203")
//                OwnerRepository().deleteOwner(this@MainActivity, owner)
//            } catch (e: Exception) {
//                println("Failed to delete from main activity ${e.message}")
//            }
//        }

    }
}