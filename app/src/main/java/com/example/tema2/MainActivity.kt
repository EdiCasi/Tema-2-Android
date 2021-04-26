package com.example.tema2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tema1.FragmentOne
import com.example.tema1.SecondFragment
import com.example.tema2.interfaces.ActivityFragmentCommunication

class MainActivity : AppCompatActivity(), ActivityFragmentCommunication {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onReplaceFragment(FragmentOne::class.java.name)
    }

    override fun onReplaceFragment(TAG: String) {
        val fragmentManager = supportFragmentManager

        val transaction = fragmentManager.beginTransaction()


        val fragment = when (TAG) {
            FragmentOne::class.java.name ->
                FragmentOne.newInstance()

            SecondFragment::class.java.name ->
                SecondFragment.newInstance()
//
//            ThirdFragmentActivityTwo::class.java.name ->
//                ThirdFragmentActivityTwo.newInstance()
//
            else->FragmentOne.newInstance()
        }

        val replaceTransaction = transaction.replace(
            R.id.fl_container,
            fragment,
            TAG
        )

        replaceTransaction.commit()
    }

    override fun onAddFragment(TAG: String) {
        TODO("Not yet implemented")
    }
}