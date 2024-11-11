package com.lion.a061ex_roomdatabase_class.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lion.a061ex_roomdatabase_class.vo.StudentVO

@Dao
interface StudentDAO {

    // 학생 정보 저장
    @Insert
    fun insertStudentData(studentVO: StudentVO)

    // 학생 정보를 가져오는 메서드
    @Query("""
        select * from StudentTable 
        order by studentIdx desc""")
    fun selectStudentDataAll() : List<StudentVO>
}