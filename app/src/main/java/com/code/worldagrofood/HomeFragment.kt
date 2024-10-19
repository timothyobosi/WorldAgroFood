package com.code.worldagrofood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var recyclerCategories: RecyclerView
    private lateinit var imgOffersBanner: ImageView
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var categoryList: MutableList<Category>  // Change here

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize views
        recyclerCategories = view.findViewById(R.id.recyclerCategories)
        imgOffersBanner = view.findViewById(R.id.imgOffersBanner)

        // Set up RecyclerView for categories
        categoryList = mutableListOf()  // Will fetch data from Firebase or a local list
        categoryAdapter = CategoryAdapter(categoryList) { category ->
            // Handle category click
            navigateToMenuFragment(category)
        }

        recyclerCategories.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = categoryAdapter
        }

        // Load categories and offers banner
        loadCategories()
        loadOffersBanner()

        return view
    }

    private fun loadCategories() {
        // Load categories data into the categoryList
        categoryList.add(Category("Beverages"))
        categoryList.add(Category("Meals"))
        categoryList.add(Category("Desserts"))
        categoryAdapter.notifyDataSetChanged()
    }

    private fun loadOffersBanner() {
        // Load image into offers banner
        imgOffersBanner.setImageResource(R.drawable.offer_banner) // Ensure this drawable exists
    }

    private fun navigateToMenuFragment(category: Category) {
        // Navigate to MenuFragment with the selected category
        val menuFragment = MenuFragment.newInstance(category)
        fragmentManager?.beginTransaction()
            ?.replace(R.id.fragmentContainer, menuFragment)
            ?.addToBackStack(null)
            ?.commit()
    }



}
