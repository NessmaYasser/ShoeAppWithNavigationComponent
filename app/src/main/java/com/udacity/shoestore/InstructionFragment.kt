package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionBinding

/**
 * A simple [Fragment] subclass.
 * Use the [InstructionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InstructionFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding : FragmentInstructionBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)
        binding.fragment = this
        return binding.root
    }

    fun onNextClicked(){
        findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment InstructionFragment.
         */
        @JvmStatic
        fun newInstance() = InstructionFragment()
    }
}