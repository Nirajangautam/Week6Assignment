package com.example.week6assignment.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.week6assignment.Student

class studentAdapter( val StudentList:ArrayList<Student>):RecyclerView.Adapter<studentAdapter.viewHolder>() {

    class viewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }
}