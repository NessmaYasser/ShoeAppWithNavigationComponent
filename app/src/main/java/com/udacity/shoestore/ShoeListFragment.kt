package com.udacity.shoestore

import android.content.res.Configuration
import android.os.Bundle
import android.view.*
import android.view.animation.Animation
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import kotlinx.android.synthetic.main.shoe_item.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.fragment = this

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, inflater: MenuInflater) {
                inflater.inflate(R.menu.menu, menu)
            }

            override fun onMenuItemSelected(item: MenuItem): Boolean {
                 if(item.itemId == R.id.loginFragment) {
                     findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
                     return true
                }else
                    return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        viewModel.shoeLiveData.observe(viewLifecycleOwner, Observer {
            for(i in it) {
                var shoeView = View.inflate(requireContext(), R.layout.shoe_item, null)
                shoeView.shoe_name_tv.text = "${getString(R.string.shoe_name)} ${i.name}"
                shoeView.shoe_company_tv.text = "${getString(R.string.company)} ${i.company}"
                shoeView.shoe_size_tv.text = "${getString(R.string.shoe_size)} ${i.size}"
                shoeView.shoe_description_tv.text = "${getString(R.string.shoe_description)} ${i.description}"
                binding.shoeListContainer.addView(shoeView)
            }

        })

        return binding.root
    }

    fun onFloatingActionClicked(){
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.menu, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        var navController = findNavController()
//        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
//    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment ShoeListFragment.
         */
        @JvmStatic
        fun newInstance() = ShoeListFragment()
    }
}