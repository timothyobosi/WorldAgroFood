package com.code.worldagrofood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class CheckoutFragment : Fragment() {

    private lateinit var officeNumberInput: EditText
    private lateinit var blockInput: EditText
    private lateinit var confirmOrderButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_checkout, container, false)

        // Initialize inputs and confirm button
        officeNumberInput = view.findViewById(R.id.office_number_input)
        blockInput = view.findViewById(R.id.block_input)
        confirmOrderButton = view.findViewById(R.id.confirm_order_button)

        confirmOrderButton.setOnClickListener {
            // Handle order confirmation (submit data)
            val officeNumber = officeNumberInput.text.toString()
            val block = blockInput.text.toString()

            if (officeNumber.isNotEmpty() && block.isNotEmpty()) {
                // Proceed with the order submission
                // You can add logic here to send order details to a backend
            } else {
                // Show error if inputs are missing
                officeNumberInput.error = "Please enter office number"
                blockInput.error = "Please enter block number"
            }
        }

        return view
    }
}
