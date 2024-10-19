package com.code.worldagrofood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuFragment : Fragment() {

    private lateinit var recyclerMenu: RecyclerView
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var foodList: MutableList<Food>

    companion object {
        private const val ARG_CATEGORY = "category"

        fun newInstance(category: Category): MenuFragment {
            val fragment = MenuFragment()
            val args = Bundle()
            args.putParcelable(ARG_CATEGORY, category)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        // Initialize RecyclerView
        recyclerMenu = view.findViewById(R.id.recyclerMenu)

        // Set up RecyclerView
        foodList = mutableListOf()  // Will fetch data from Firebase or local
        foodAdapter = FoodAdapter(foodList) { food ->
            // Handle food item click, e.g., add to cart
        }

        recyclerMenu.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = foodAdapter
        }

        // Load food items for the selected category
        val category = arguments?.getParcelable<Category>(ARG_CATEGORY)
        loadFoodItems(category)

        return view
    }

    private fun loadFoodItems(category: Category?) {
        // Load food items based on the selected category (use Firebase or static data)
        foodList.add(Food("Burger", 5.99))
        foodList.add(Food("Pizza", 8.99))
        foodAdapter.notifyDataSetChanged()
    }



}
