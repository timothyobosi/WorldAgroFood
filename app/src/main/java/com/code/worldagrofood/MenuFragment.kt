package com.code.worldagrofood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuFragment : Fragment() {

    private lateinit var menuRecyclerView: RecyclerView
    private lateinit var menuAdapter: FoodAdapter
    private lateinit var menuList: MutableList<Food>

    companion object {

        fun newInstance(category: Category): MenuFragment {
            val fragment = MenuFragment()
            val args = Bundle()
            args.putParcelable("category", category)
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

        //Initialize RecyclerView
        menuRecyclerView = view.findViewById(R.id.menu_recycler_view)


        //dummy food items ( we will  replace with actual logic)
        menuList = mutableListOf(
            Food("Latte", 250.0,1),
            Food("Espresso",200.0,1)
        )

        // Set up the RecyclerView with the FoodAdapter and handle item clicks
        menuAdapter = FoodAdapter(menuList) { foodItem ->
            // Handle item click (e.g., add to cart or navigate to food details)
            // You can show a toast or add the food item to the cart
        }

        menuRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = menuAdapter
        }

        return view

        return view
    }




}
