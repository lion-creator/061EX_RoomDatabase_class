package com.lion.a061ex_roomdatabase_class.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lion.a061ex_roomdatabase_class.MainActivity
import com.lion.a061ex_roomdatabase_class.R
import com.lion.a061ex_roomdatabase_class.databinding.FragmentInputBinding
import com.lion.a061ex_roomdatabase_class.util.FragmentName

class InputFragment : Fragment() {

    lateinit var fragmentInputBinding: FragmentInputBinding
    lateinit var mainActivity: MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        fragmentInputBinding = FragmentInputBinding.inflate(layoutInflater)
        mainActivity = activity as MainActivity

        // 툴바를 구성하는 메서드를 호출한다.
        settingToolbar()

        return fragmentInputBinding.root
    }

    // Toolbar를 설정하는 메서드
    fun settingToolbar(){
        fragmentInputBinding.apply {
            // 타이틀
            toolbarInput.title = "학생 정보 입력"
            // 네비게이션 아이콘
            toolbarInput.setNavigationIcon(R.drawable.arrow_back_24px)
            toolbarInput.setNavigationOnClickListener {
                // 이전 화면으로 돌아간다.
                mainActivity.removeFragment(FragmentName.INPUT_FRAGMENT)
            }
            // 메뉴
            toolbarInput.inflateMenu(R.menu.input_toolbar_menu)
            toolbarInput.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.input_toolbar_menu_done -> {
                        mainActivity.removeFragment(FragmentName.INPUT_FRAGMENT)
                    }
                }
                true
            }
        }
    }
}