package com.udacity.shoestore

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.User


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private val user = User()
    lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

//            binding.loginBtn.setOnClickListener{
//                if(!binding.emailEdittext.text.isNullOrBlank() && !binding.passwordEdittext.text.isNullOrBlank()) {
//                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
//                }else{
//                    Toast.makeText(requireContext(), getString(R.string.please_fill_all_fields), Toast.LENGTH_SHORT).show()
//                }
//            }

        binding.fragment = this


        return binding.root
    }

    fun loginClick(){
//        binding.loginBtn.setOnClickListener{
            if(!binding.emailEdittext.text.isNullOrBlank() && !binding.passwordEdittext.text.isNullOrBlank()) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }else{
                Toast.makeText(requireContext(), getString(R.string.please_fill_all_fields), Toast.LENGTH_SHORT).show()
            }
//        }
    }

    fun isEmailValid(email: String?): Boolean {
        return if (email.isNullOrBlank())
            false
        else android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isPasswordValid(password: String?): Boolean {
        return !(password.isNullOrBlank() || password.length < 6)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment LoginFragment.
         */
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}