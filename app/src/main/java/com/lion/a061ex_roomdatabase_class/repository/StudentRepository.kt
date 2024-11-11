package com.lion.a061ex_roomdatabase_class.repository

import android.content.Context
import com.lion.a061ex_roomdatabase_class.dao.StudentDatabase
import com.lion.a061ex_roomdatabase_class.viewmodel.StudentViewModel
import com.lion.a061ex_roomdatabase_class.vo.StudentVO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class StudentRepository {

    companion object{

        // 학생 정보를 저장하는 메서드
        fun insertStudentInfo(context: Context, studentViewModel: StudentViewModel){
            // 데이터베이스 객체를 가져온다.
            val studentDatabase = StudentDatabase.getInstance(context)
            // ViewModel에 있는 데이터를 VO에 담아준다.
            val studentType = studentViewModel.studentType.number
            val studentName = studentViewModel.studentName
            val studentAge = studentViewModel.studentAge

            val studentVO = StudentVO(studentType = studentType, studentName = studentName, studentAge = studentAge)

            CoroutineScope(Dispatchers.Main).launch {
                async(Dispatchers.IO){
                    // 저장한다.
                    studentDatabase?.studentDAO()?.insertStudentData(studentVO)
                }
            }
        }
    }
}