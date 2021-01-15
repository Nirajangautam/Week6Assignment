package com.example.week6assignment.model

val studentList= mutableListOf<Student>()
class Database() {
    fun addStudent(student: Student) {
        studentList.add(student)
    }

    fun returnStudent(): MutableList<Student> {
        return studentList
    }

    fun deleteStudent(student: Student) {
        studentList.remove(student)
    }
}