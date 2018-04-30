package com.silambar.snackdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout.LayoutParams
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    setSupportActionBar(toolbar)
    init()
  }


  private fun init() {

    btnSimple.setOnClickListener {
      val snackBar = Snackbar.make(it, "Checking internet connection!.....", Snackbar.LENGTH_LONG)
      snackBar.show()
    }

    btnCallback.setOnClickListener {
      val snackBar = Snackbar.make(it, "Simple snack bar clicked with callback!",
          Snackbar.LENGTH_LONG)
          .setAction("UNDO", {
            btnSimple.performClick()
          })
      snackBar.show()
    }

    btnCustom.setOnClickListener {
      val snackBar = Snackbar.make(it, "No internet connection!", Snackbar.LENGTH_LONG)
          .setAction("RETRY", {
            btnSimple.performClick()
          })
      snackBar.setActionTextColor(ContextCompat.getColor(this@MainActivity, android.R.color.holo_orange_light))
      val view = snackBar.view

      (view.layoutParams as LayoutParams).setMargins(16, 16, 16, 16)

      view.background = ContextCompat.getDrawable(this@MainActivity, R.drawable.snackbar_background)
      val textView = view.findViewById<TextView>(android.support.design.R.id.snackbar_text)
      textView.setTextColor(ContextCompat.getColor(this@MainActivity, android.R.color.white))
      textView.gravity = Gravity.CENTER_VERTICAL
      textView.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_launcher, 0, 0, 0)
      snackBar.show()
    }
  }
}
