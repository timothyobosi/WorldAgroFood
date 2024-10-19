package com.code.worldagrofood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentCart : Fragment() {

    private lateinit var recyclerCart: RecyclerView
    private lateinit var cartAdapter: CartAdapter
    private lateinit var cartList: MutableList<Food>
    private lateinit var btnCheckout: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        // Initialize RecyclerView and checkout button
        recyclerCart = view.findViewById(R.id.recyclerCart)
        btnCheckout = view.findViewById(R.id.btnCheckout)

        // Set up RecyclerView
        cartList = mutableListOf()  // Will fetch from cart data source
        cartAdapter = CartAdapter(cartList) { food ->
            // Handle cart item removal or quantity change
        }

        recyclerCart.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = cartAdapter
        }

        // Load cart items
        loadCartItems()

        // Handle checkout button click
        btnCheckout.setOnClickListener {
            navigateToCheckoutFragment()
        }

        return view
    }

    private fun loadCartItems() {
        // Load cart items (use local data or fetch from Firebase)
        cartList.add(Food("Burger", 5.99, 2))
        cartList.add(Food("Pizza", 8.99, 1))
        cartAdapter.notifyDataSetChanged()
    }

    private fun navigateToCheckoutFragment() {
        val checkoutFragment = CheckoutFragment()
        fragmentManager?.beginTransaction()
            ?.replace(R.id.fragmentContainer, checkoutFragment)
            ?.addToBackStack(null)
            ?.commit()
    }


}
