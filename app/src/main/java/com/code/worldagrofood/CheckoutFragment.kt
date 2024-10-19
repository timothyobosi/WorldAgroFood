package com.code.worldagrofood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CheckoutFragment : androidx.fragment.app.Fragment() {

    private lateinit var editBuildingBlock: EditText
    private lateinit var editOfficeNumber: EditText
    private lateinit var btnPlaceOrder: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_checkout, container, false)

        // Initialize views
        editBuildingBlock = view.findViewById(R.id.editBuildingBlock)
        editOfficeNumber = view.findViewById(R.id.editOfficeNumber)
        btnPlaceOrder = view.findViewById(R.id.btnPlaceOrder)

        // Handle order placement
        btnPlaceOrder.setOnClickListener {
            placeOrder()
        }

        return view
    }

    private fun placeOrder() {
        val buildingBlock = editBuildingBlock.text.toString()
        val officeNumber = editOfficeNumber.text.toString()

        if (buildingBlock.isNotEmpty() && officeNumber.isNotEmpty()) {
            // Place the order, e.g., save it to Firebase
            Toast.makeText(context, "Order placed successfully!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
        }
    }



}
