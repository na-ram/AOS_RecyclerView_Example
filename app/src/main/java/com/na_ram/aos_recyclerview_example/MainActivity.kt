package com.na_ram.aos_recyclerview_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.RecyclerView
import com.na_ram.aos_recyclerview_example.adapter.RecyclerAdapter
import com.na_ram.aos_recyclerview_example.model.User

class MainActivity : AppCompatActivity() {

    private val rvUserRecyclerView : RecyclerView by lazy {
        findViewById(R.id.rvUserRecyclerView)
    }

    private lateinit var RecyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userList: MutableList<User> = mutableListOf(
            User("테스트1", 20),
            User("테스트2", 25),
            User("테스트3", 42),
            User("테스트4", 66)
        )

        RecyclerAdapter = RecyclerAdapter()
        RecyclerAdapter.datas = userList
        rvUserRecyclerView.adapter = RecyclerAdapter

        // 데이터 추가, 삭제, 수정 예제
        Handler(Looper.getMainLooper()).postDelayed({
            userList[0].userAge = 30
            RecyclerAdapter.notifyItemChanged(0)

            userList.add(User("테스트5", 18))
            val position = RecyclerAdapter.itemCount
            RecyclerAdapter.notifyItemInserted(position)
        }, 2000)

        Handler(Looper.getMainLooper()).postDelayed({
            userList.removeAt(1)
            RecyclerAdapter.notifyItemRemoved(1)

            userList.add(User("테스트6", 51))
            val position = RecyclerAdapter.itemCount
            RecyclerAdapter.notifyItemInserted(position)
        }, 5000)

    }
}