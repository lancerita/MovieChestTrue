package com.example.moviechest.presentation

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.moviechest.R

class ExitDialogFragment: DialogFragment() {
  
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(getString(R.string.exit_question))
            .setPositiveButton(getString(R.string.exit_agree)) {
                dialog, id -> MainActivity().onBackPressed()
            }
                .setNegativeButton(getString(R.string.exite_refuse)) {
                        dialog, id ->dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException (getString(R.string.activity_cannot_be_null))
    }
}
