package com.example.roomdatabasedemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity() {

    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = ContactDatabase.getDatabase(this)
        GlobalScope.launch{
            database.contactDAO().insertContact(Contact(0,"KGirish","1234", Date()))
        }
    }

    fun getData(view: View) {
        database.contactDAO().getContact().observe(this, Observer {
            Log.d("LogForGirish",it.toString())
        })
    }
}