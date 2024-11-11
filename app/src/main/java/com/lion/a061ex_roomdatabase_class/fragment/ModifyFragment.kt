package com.lion.a061ex_roomdatabase_class.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lion.a061ex_roomdatabase_class.MainActivity
import com.lion.a061ex_roomdatabase_class.R
import com.lion.a061ex_roomdatabase_class.databinding.FragmentModifyBinding
import com.lion.a061ex_roomdatabase_class.util.FragmentName

class ModifyFragment : Fragment() {

    lateinit var fragmentModifyBinding: FragmentModifyBinding
    lateinit var mainActivity: MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentModifyBinding = FragmentModifyBinding.inflate(inflater)
        mainActivity = activity as MainActivity

        // Toolbar 설정 메서드를 호출한다.
        settingToolbar()
        // 입력 요소들 초기 설정
        settingInput()

        return fragmentModifyBinding.root
    }

    // Toolbar 설정 메서드
    fun settingToolbar(){
        fragmentModifyBinding.apply {
            // 타이틀
            toolbarModify.title = "학생 정보 수정"
            // 네비게이션
            toolbarModify.setNavigationIcon(R.drawable.arrow_back_24px)
            toolbarModify.setNavigationOnClickListener {
                mainActivity.removeFragment(FragmentName.MODIFY_FRAGMENT)
            }
            // 메뉴
            toolbarModify.inflateMenu(R.menu.modify_toolbar_menu)
            toolbarModify.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.modify_toolbar_menu_done ->{
                        mainActivity.removeFragment(FragmentName.MODIFY_FRAGMENT)
                    }
                }
                true
            }
        }
    }

    // 입력 요소들 초기 설정
    fun settingInput(){
        fragmentModifyBinding.apply {
            // 운동부
            toggleGroupModifyType.check(R.id.buttonModifyTypeBaseBall)
            // 이름
            textFieldModifyName.editText?.setText("홍길동")
            // 나이
            textFieldModifyAge.editText?.setText("30")
        }
    }

}