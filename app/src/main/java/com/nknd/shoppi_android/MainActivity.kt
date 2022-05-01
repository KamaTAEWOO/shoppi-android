package com.nknd.shoppi_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    //최초 한번만 할 메소드만 넣기.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "OnCreate")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    // 데이터 갱신, 애니메이션 실행을 여기서 처리함.
    // 화면이 꺼졌다가 다시 실행될 때 사용함.
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    // Activity가 Focus를 얻었다라고 함.
    // 화면에 보여지고 있는 상태
    // 너무 오래 걸리는 연산을 여기에 넣으면 안 됨(너무 자주 호출되기 때문임.)
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    // OnResume과 반대로 Focus를 잃었을 때 사용함.
    // 너무 오래 걸리는 연산을 여기에 넣으면 안 됨(너무 자주 호출되기 때문임.)
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    // OnStart와 대응해서 생각하기
    // 중단가능
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    // 사용중인 앱 자체가 완전히 제거될 때 호출 됨.
    // onStop에서 제거되지 않은 리소스를 깔끔하게 제거할 때 실행함.
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}