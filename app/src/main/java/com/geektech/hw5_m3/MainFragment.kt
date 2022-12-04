package com.geektech.hw5_m3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.geektech.hw5_m3.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding // создала биндинг

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false) // инициализировала биндинг
        return binding.root  // дала разрешение биндингу (xml)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var isPlus = true      

        binding.btnPlus.setOnClickListener{
            var number = binding.number.text.toString().toInt()

            if (isPlus){
                var newNumber = number + 1
                binding.number.text = newNumber.toString()

                if (newNumber == 10){
                    binding.btnPlus.text = "-"
                    isPlus = false
                }
            } else {
                var newNumber = number - 1
                binding.number.text = newNumber.toString()

                if (newNumber == 0){
                    requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container, SecondFragment()).addToBackStack(null).commit()
                }                                                                                       // addToBackStack - переход на предыдущий фрагмент
            }


        }


    }
}