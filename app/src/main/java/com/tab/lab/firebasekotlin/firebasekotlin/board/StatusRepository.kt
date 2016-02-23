package com.tab.lab.firebasekotlin.firebasekotlin.board

import android.util.Log
import com.firebase.client.DataSnapshot
import com.firebase.client.Firebase
import com.firebase.client.FirebaseError
import com.firebase.client.ValueEventListener

/**
 * Created by swav on 23/02/2016.
 */
class StatusRepository {

    val firebase: Firebase = Firebase("https://<your-server>.firebaseio.com")

    fun loadCurrentWeek() {
        firebase
                .child("status_app")
                    .child("current_week")
                    .addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.i("Firebase:", "current_week:" + snapshot.value)
            }

            override fun onCancelled(error: FirebaseError?) {
                Log.e("Firebase:", "error!")
            }
        }
        )
    }

    fun loadStatus(week: Int) {

        firebase
                .child("status_app")
                    .child("weeks")
                        .child(week.toString())
                            .child("projects")
                            .addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child: DataSnapshot in snapshot.children) {
                    val serialized: Project = child.getValue(Project::class.java)
                    Log.i("Firebase:", serialized.toString())
                }
            }

            override fun onCancelled(e: FirebaseError?) {
                Log.e("Firebase:", e.toString())
            }
        })

    }
}