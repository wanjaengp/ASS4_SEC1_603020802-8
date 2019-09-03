package com

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.ass4labui.R
import java.text.DateFormat
import java.util.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
    private lateinit var calendar: Calendar
    @SuppressLint("ResourceType")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireActivity(), 2, this, year, month, day
        )
    }
    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        Toast.makeText(activity, "Date Set : ${formatDate(year,month,day)}",Toast.LENGTH_SHORT).show()
        activity!!.findViewById<TextView>(R.id.text_date).text = formatDate(year,month,day)
    }
    override fun onCancel(dialog: DialogInterface?) {
        Toast.makeText(activity,"Please select a date.", Toast.LENGTH_SHORT).show()
        super.onCancel(dialog)
    }
    private fun formatDate(year:Int, month:Int, day:Int):String{
        calendar.set(year, month, day, 0, 0, 0)
        val chosenDate = calendar.time
        val df = DateFormat.getDateInstance(DateFormat.SHORT)
        return df.format(chosenDate)
    }
}