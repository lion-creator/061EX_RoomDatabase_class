package com.lion.a061ex_roomdatabase_class.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lion.a061ex_roomdatabase_class.MainActivity
import com.lion.a061ex_roomdatabase_class.R
import com.lion.a061ex_roomdatabase_class.databinding.FragmentShowBinding
import com.lion.a061ex_roomdatabase_class.repository.StudentRepository
import com.lion.a061ex_roomdatabase_class.util.FragmentName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ShowFragment : Fragment() {

    lateinit var fragmentShowBinding: FragmentShowBinding
    lateinit var mainActivity: MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentShowBinding = FragmentShowBinding.inflate(inflater)
        mainActivity = activity as MainActivity

        // 툴바 설정 메서드 호출
        settingToolbar()
        // 데이터를 가져와 출력한다.
        settingTextView()

        return fragmentShowBinding.root
    }

    // 툴바 설정 메서드
    fun settingToolbar(){
        fragmentShowBinding.apply {
            // 타이틀
            toolbarShow.title = "학생 정보 보기"
            // 네비게이션
            toolbarShow.setNavigationIcon(R.drawable.arrow_back_24px)
            toolbarShow.setNavigationOnClickListener {
                mainActivity.removeFragment(FragmentName.SHOW_FRAGMENT)
            }
            // 메뉴
            toolbarShow.inflateMenu(R.menu.show_toolbar_menu)
            toolbarShow.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.show_toolbar_menu_edit -> {
                        // ModifyFragment로 이동한다.
                        mainActivity.replaceFragment(FragmentName.MODIFY_FRAGMENT, true, null)
                    }
                    R.id.show_toolbar_menu_delete -> {
                        mainActivity.removeFragment(FragmentName.SHOW_FRAGMENT)
                    }
                }
                true
            }
        }
    }

    // TextView에 값을 설정하는 메서드
    fun settingTextView(){
        // 만일의 경우를 위해 TextView들을 초기화 해준다.
        fragmentShowBinding.textViewShowType.text = ""
        fragmentShowBinding.textViewShowName.text = ""
        fragmentShowBinding.textViewShowAge.text = ""
        // 학생 번호를 추출한다.
        val studentIdx = arguments?.getInt("studentIdx")
        // 학생 데이터를 가져와 출력한다.
        CoroutineScope(Dispatchers.Main).launch {
            val work1 = async(Dispatchers.IO){
                StudentRepository.selectStudentInfoByStudentIdx(mainActivity, studentIdx!!)
            }
            val studentViewModel = work1.await()

            fragmentShowBinding.textViewShowType.text = studentViewModel.studentType.str
            fragmentShowBinding.textViewShowName.text = studentViewModel.studentName
            fragmentShowBinding.textViewShowAge.text = studentViewModel.studentAge.toString()
        }
    }
}