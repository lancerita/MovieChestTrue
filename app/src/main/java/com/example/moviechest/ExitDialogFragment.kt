package com.example.moviechest

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ExitDialogFragment: DialogFragment() {
    val mainActivity = MainActivity()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Выйти из приложения?")
            .setPositiveButton("Да, выйти") {
                dialog, id -> mainActivity.onBackPressed()
            }
                .setNegativeButton("Heт, остаться") {
                        dialog, id ->dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException ("Activity cannot be null")
    }
}