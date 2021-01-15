package com.example.week6assignment.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week6assignment.R
import com.example.week6assignment.model.Database
import com.example.week6assignment.model.Student
import com.example.week6assignment.model.studentList
import de.hdodenhof.circleimageview.CircleImageView

class studentAdapter(val StudentList:MutableList<Student>, val context: Context):RecyclerView.Adapter<studentAdapter.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):viewHolder {
       val v =LayoutInflater.from(parent.context).inflate(R.layout.studentlayout,parent,false)
        return viewHolder(v)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val std =StudentList[position]
        holder.txtAdd?.text=std.Address
        holder.txtName?.text=std.Name
        holder.txtGender.text=std.Gender
        holder.txtAge.text=std.Age
        Glide.with(context).load(std.img).into(holder.imgProfile)

        holder.btnDelete.setOnClickListener{
            Database().deleteStudent(std)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return StudentList.size
    }
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName=itemView.findViewById(R.id.txtName)as TextView
        val txtAge=itemView.findViewById(R.id.txtAge)as TextView
        val txtAdd=itemView.findViewById(R.id.txtAdd)as TextView
        val txtGender=itemView.findViewById(R.id.txtGender)as TextView
        val imgProfile=itemView.findViewById(R.id.imgProfile)as CircleImageView
        val btnDelete = itemView.findViewById(R.id.imgBtn) as ImageButton

    }

}


