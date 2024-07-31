package com.ex.homework8_3month

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.ex.homework8_3month.databinding.FragmentChoseBinding

class ChoseFragment : Fragment() {
    private lateinit var binding: FragmentChoseBinding
    private val themeList = arrayListOf(
        Theme("VideoGames", "https://i.ytimg.com/vi/-6_ubOJLa7k/maxresdefault.jpg?sqp=-oaymwEmCIAKENAF8quKqQMa8AEB-AH-CYAC0AWKAgwIABABGBggZChyMA8=&rs=AOn4CLAcYLbjBYz1gSbqVgF4fbPrWDtsRw"),
        Theme("IT", "https://programmera.ru/wp-content/uploads/2017/08/3f3c2435aa9d.png"),
        Theme("SECRET", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTIzvBVsJhOPvzUqLIZCA1DU-vn_ipTrqM_Kg&s")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChoseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val adapter = ThemeAdapter(themeList, this::onClick)
        binding.rvTheme.adapter = adapter
    }

    private fun onClick(theme: Theme) {
        val fact: String = when (theme.text) {
            "VideoGames" -> "Го в доту я создал\n" +
                    "Го в роту я не сдал"
            "IT" -> "ПИТОН ГАВНО)"
            "SECRET" -> "Я ЛЮБЛЮ ASSEMBLY"
            else -> "?"
        }
        val bundle = bundleOf("ThemeText" to theme.text, "Fact" to fact)
        findNavController().navigate(R.id.action_choseFragment_to_detailFragment, bundle)
    }
}
