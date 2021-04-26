package com.example.tema1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tema2.R
import com.example.tema2.adapters.MyAdapter
import com.example.tema2.interfaces.ActivityFragmentCommunication
import com.example.tema2.models.User

import kotlinx.android.synthetic.main.fragment_one.view.*

class FragmentOne : Fragment() {

    var activityFragmentCommunication: ActivityFragmentCommunication? = null

    private lateinit var viewOfLayout: View

    companion object {
        fun newInstance(): Fragment {
            return FragmentOne()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            is ActivityFragmentCommunication ->
                activityFragmentCommunication = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val view = inflater.inflate(R.layout.fragment_one, container, false)
        viewOfLayout = inflater!!.inflate(R.layout.fragment_one, container, false)

        setUpRecyclerView()

        return viewOfLayout
    }

    fun setUpRecyclerView() {
        val recyclerView: RecyclerView = viewOfLayout.userList

        val layoutManager: LinearLayoutManager = LinearLayoutManager(context)

        recyclerView.layoutManager = layoutManager

        val users: ArrayList<User> = ArrayList<User>()

        users.add(User("Ion"))
        users.add(User("Marcel"))
        users.add(User("Danut"))
        users.add(User("Dumitru"))

        val adapter = MyAdapter(users)

        recyclerView.adapter = adapter
    }

}