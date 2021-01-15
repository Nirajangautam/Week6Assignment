package com.example.week6assignment.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week6assignment.Adapter.studentAdapter
import com.example.week6assignment.R
import com.example.week6assignment.model.Database
import com.example.week6assignment.model.Student

class HomeFragment : Fragment() {
    private lateinit var details:RecyclerView
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        details = root.findViewById(R.id.recyclerView)

        val adapterView = context?.let { studentAdapter(Database().returnStudent(), it) }
        details.layoutManager = LinearLayoutManager(activity)
        details.adapter = adapterView
        return root
    }
}