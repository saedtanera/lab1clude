package com.example.lap1clude

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class MainActivity : AppCompatActivity() {

    val db = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var save = findViewById<Button>(R.id.button)
       var PersonName=findViewById<EditText>(R.id.editTextTextPersonName3)
       var PersonID=findViewById<EditText>(R.id.editTextTextPersonName4)
       var PersonAge=findViewById<EditText>(R.id.editTextTextPersonName5)

        save.setOnClickListener {
            var name = PersonName. text. toString()
            var id = PersonID. text. toString()
            var age = PersonAge. text. toString()
            val person = hashMapOf(
                "name" to name,
                "id" to id,
                "age" to age
            )


            db.collection("Person")
                .add(person)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(applicationContext, "${documentReference.id}",Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener  e ->
            Toast.makeText(applicationContext, "${e}",Toast.LENGTH_LONG).show()

        }


    }
}