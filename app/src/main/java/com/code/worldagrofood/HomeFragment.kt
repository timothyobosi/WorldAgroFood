package com.code.worldagrofood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var searchBar:EditText
    private lateinit var eateriesRecyclerView: RecyclerView
    private lateinit var eateriesAdapter: CategoryAdapter
    private lateinit var eateriesList: MutableList<Category>


    private lateinit var featuredDishesRecyclerView: RecyclerView
    private lateinit var promotionsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize search bar and RecyclerView
        searchBar = view.findViewById(R.id.search_bar)
        eateriesRecyclerView = view.findViewById(R.id.eateries_recycler_view)

        //Set up RecyclerView
        eateriesList = mutableListOf(
            Category("Evergreen",R.drawable.evergreen),
            Category("Coffee Shop",R.drawable.coffeeshop),
            Category("Main Cafeteria",R.drawable.main_cafeteria)
        )

        eateriesAdapter = CategoryAdapter(eateriesList){ category ->
            //Handle eatery click(navigate to MenuFragment for the selected eatery
            val fragment = MenuFragment.newInstance(category)
            childFragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, fragment)
                ?.addToBackStack(null)
                ?.commit()

        }

        eateriesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = eateriesAdapter
        }

        return view

    }



}
