package com.lion.a061ex_roomdatabase_class.viewmodel

import com.lion.a061ex_roomdatabase_class.util.StudentType

data class StudentViewModel(
    var studentIdx:Int,
    var studentType: StudentType,
    var studentName:String,
    var studentAge:Int
)