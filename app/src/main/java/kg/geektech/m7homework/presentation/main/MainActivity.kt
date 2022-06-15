package kg.geektech.m7homework.presentation.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.geektech.M7HOMEWORK.R
import kg.geektech.M7HOMEWORK.databinding.ActivityMainBinding
import kg.geektech.m7homework.core.extentions.showToastShort
import kg.geektech.m7homework.domain.model.ShopItem

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var viewModel: MainViewModel
    private val binding by viewBinding(ActivityMainBinding::bind, R.id.main_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        initObservers()
        initListeners()
    }

    private fun initListeners() {
        //add shopItem
        binding.btnAddShopItem.setOnClickListener {
            if (binding.editText.text.toString().isNotEmpty())
                viewModel.addShopItem(ShopItem(binding.editText.text.toString(), 2, true))
            else showToastShort("Заполните поле текстом")

        }
        //edit ShopItem
        binding.btnEditShopItem.setOnClickListener {
            val text = viewModel.getShopItem(binding.editText.text.toString().toInt())
            if (text != null) {
                viewModel.editShopItem(text)
            }
        }
        //delete ShopItem
        binding.btnDeleteShopItem.setOnClickListener {
            if (binding.editText.text.toString().isNotEmpty())
                viewModel.deleteShopItem(ShopItem(binding.editText.text.toString(), 2, true))
            else showToastShort("Заполните поле индексом")

        }
        //get shopItem
        binding.btnGetShopItem.setOnClickListener {
            if (binding.editText.text.toString().isNotEmpty())
                viewModel.getShopItem(binding.editText.text.toString().toInt())
            else showToastShort("Заполните поле индексом")
        }
    }

    private fun initObservers() {
        viewModel.shopListLD.observe(this) {//observe наблюдатель
            Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_LONG).show()
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }
}