package com.example.tema1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tema2.R
import com.example.tema2.interfaces.ActivityFragmentCommunication

class SecondFragment : Fragment() {

    var activityFragmentCommunication: ActivityFragmentCommunication? = null

    companion object {
        fun newInstance(): Fragment {
            return SecondFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            is ActivityFragmentCommunication ->
                activityFragmentCommunication = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.second_fragment, container, false)

        return view
    }


}