package com.lion.a061ex_roomdatabase_class.dao

import androidx.room.Dao
import androidx.room.Insert
import com.lion.a061ex_roomdatabase_class.vo.StudentVO

@Dao
interface StudentDAO {

    // 학생 정보 저장
    @Insert
    fun insertStudentData(studentVO: StudentVO)
}