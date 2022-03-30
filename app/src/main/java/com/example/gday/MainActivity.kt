package com.example.gday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.example.gday.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.activity_main)

        setChipGroupDynamically()
    }

    private fun setChipGroupDynamically(){
        val chipGroup = ChipGroup(this)
        chipGroup.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        chipGroup.isSingleSelection = true
        chipGroup.isSingleLine = false

        chipGroup.addView(createChip("India"))
        chipGroup.addView(createChip("Nepal"))
        chipGroup.addView((createChip("USA")))
        chipGroup.addView(createChip("South Africa"))

        binding.rootContainer.addView(chipGroup)
    }

    private fun createChip(label:String):Chip{
        val chip = Chip(this, null, R.style.Widget_MaterialComponents_Chip_Entry)
        chip.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        chip.text = label
        chip.isCloseIconVisible = true
        chip.isCheckable = true
        chip.isClickable = true
        chip.setOnCloseIconClickListener {
            Toast.makeText(this, "Chip deleted succesfully!", Toast.LENGTH_SHORT).show()
        }
        return chip
    }

}