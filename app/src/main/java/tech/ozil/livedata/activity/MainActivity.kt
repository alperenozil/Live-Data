package tech.ozil.livedata.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import tech.ozil.livedata.R
import tech.ozil.livedata.viewmodel.TestViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: TestViewModel
    lateinit var increase_button: Button
    lateinit var count_text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        increase_button=findViewById<Button>(R.id.increase_number)
        viewModel= ViewModelProvider(this).get(viewModel::class.java)
        increase_button.setOnClickListener{
            viewModel.currentNumber.value=++viewModel.number
        }
        viewModel.currentNumber.observe(this, Observer {
            count_text.text=viewModel.currentNumber.toString()
        })
    }
}