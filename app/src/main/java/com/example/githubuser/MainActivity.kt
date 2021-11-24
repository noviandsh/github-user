package com.example.githubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvUserList: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvUserList = binding.rvUserlist
        rvUserList.setHasFixedSize(true)

        binding.menuButton.setOnClickListener{
            Toast.makeText(binding.root.context, "Coming soon!", Toast.LENGTH_SHORT).show()
        }

        list.addAll(listUsers)
        showRecyclerList()
    }
//
    private val listUsers: ArrayList<User>
        get() {
            val dataName = resources.getStringArray(R.array.name)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataFollower = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val listUser = ArrayList<User>()
            for (i in dataName.indices) {
                val user = User(
                    dataName[i],
                    dataUsername[i],
                    dataPhoto.getResourceId(i, -1),
                    dataLocation[i],
                    dataCompany[i],
                    dataRepository[i],
                    dataFollower[i],
                    dataFollowing[i]
                )
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecyclerList() {
        rvUserList.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUserList.adapter = listUserAdapter
    
        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(user: User) {
                showUserDetail(user)
            }
        })
    }

    private fun showUserDetail(user: User) {
        val userDetailIntent = Intent(this@MainActivity, UserDetailActivity::class.java)
        userDetailIntent.putExtra(UserDetailActivity.EXTRA_USER, user)
        startActivity(userDetailIntent)
    }
}