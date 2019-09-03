package com.example.ass4labui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import com.DatePickerFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var selected: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup?.setOnCheckedChangeListener { group, checkedId ->
            var select = ""
            select += if (R.id.male == checkedId)
                "Male"
            else if (R.id.female == checkedId)
                "Female"
            else
                ""
            selected = select

        }
    }

    fun ShowDatePickerDialog(v: View){
        val newDateFragment = DatePickerFragment()
        newDateFragment.show(supportFragmentManager, "Date Picker")
    }
    fun register(view: View){
        text_show.text = "Name: ${edit_name.text}\nPassword: ${edit_password.text}\nGender: $selected\nEmail: ${text_email.text}\nBirthday: ${text_date.text}"
    }
    fun reset(v: View){
        edit_name.text.clear()
        edit_password.text.clear()
        radioGroup.clearCheck()
        text_email.text.clear()
        text_date.text="mm/dd/yy"
        text_show.text = "Show Information"

    }

}