package com.example.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.githubuser.databinding.ActivityUserDetailBinding

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        binding.tvDetailName.text = user.name
        binding.tvDetailUsername.text = user.username
        binding.tvFollowerCount.text = user.follower
        binding.tvFollowingCount.text = user.following
        binding.tvRepositoryCount.text = user.repository
        binding.tvDetailLocation.text = user.location
        binding.tvDetailCompany.text = user.company
        Glide.with(binding.root.context)
            .load(user.photo)
            .circleCrop()
            .into(binding.imgDetailPhoto)
    }
}