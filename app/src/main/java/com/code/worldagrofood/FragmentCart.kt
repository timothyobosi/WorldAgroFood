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

    private lateinit var cartRecyclerView: RecyclerView
    private lateinit var cartAdapter: CartAdapter
    private lateinit var cartList: MutableList<Food>
    private lateinit var checkoutButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        // Initialize RecyclerView and checkout button
        cartRecyclerView = view.findViewById(R.id.cart_recycler_view)
        checkoutButton = view.findViewById(R.id.checkout_button)

        //Dummy cart items(replace with actual logic)
        cartList = mutableListOf(
            Food("Coffee", 150.0,2),
            Food("Salad",100.0,1)
        )

        cartAdapter = CartAdapter(cartList){itemToRemove->

            // Remove the item from the cart and notify the adapter
            cartList.remove(itemToRemove)
            cartAdapter.notifyDataSetChanged()

        }

        cartRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter  = cartAdapter
        }

        //handle checkout button click
        checkoutButton.setOnClickListener {
            val fragment = CheckoutFragment()
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, fragment)
                ?.addToBackStack(null)
                ?.commit()
        }

        return view
    }


}
