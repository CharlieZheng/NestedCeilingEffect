package com.tory.nestedceiling.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import cc.solart.nestedceilinge.app.R
import com.tory.module_adapter.base.NormalModuleAdapter
import com.tory.nestedceiling.app.page.NestedParentRecyclerViewActivity
import com.tory.nestedceiling.app.page.TransparentToolbarActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        btn1.setOnClickListener {
            val intent = Intent(this, NestedParentRecyclerViewActivity::class.java)
            intent.putExtra("isViewPager2", false)
            startActivity(intent)
        }

        btn2.setOnClickListener {
            val intent = Intent(this, NestedParentRecyclerViewActivity::class.java)
            intent.putExtra("isViewPager2", true)
            startActivity(intent)
        }
        btn3.setOnClickListener {
            startActivity(Intent(this, TransparentToolbarActivity::class.java))
        }
    }
}
