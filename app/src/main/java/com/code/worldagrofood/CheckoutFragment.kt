package com.code.worldagrofood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CheckoutFragment : androidx.fragment.app.Fragment() {

    private lateinit var officeBlockEditText: EditText
    private lateinit var officeNumberEditText: EditText
    private lateinit var placeOrderButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_checkout, container, false)

        // Initialize EditTexts and Button
        officeBlockEditText = view.findViewById(R.id.office_block_edit_text)
        officeNumberEditText=view.findViewById(R.id.office_number_edit_text)
        placeOrderButton = view.findViewById(R.id.place_order_button)

        placeOrderButton.setOnClickListener {

        }

        return view
    }


}
