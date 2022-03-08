package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        //Listener for the login button
        binding.btnLogin.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment)

                )
        //Listener for the login with account button
        binding.btnLoginWithAccount.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment)
                )

        return binding.root
//
        }

}
