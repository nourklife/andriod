package com.example.food.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.food.R
import com.example.food.database.RecipeDatabase
import com.example.food.entites.Categories
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@AndroidEntryPoint
class SplashActivity : AppCompatActivity(), EasyPermissions.RationaleCallbacks,
    EasyPermissions.PermissionCallbacks {

    lateinit var dp: RecipeDatabase

    private var READ_S = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mButtonStart().isEnabled = false
        readeSorageTask()
        mButtonStart().setOnClickListener {
            var intent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    fun mButtonStart(): Button {
        val mButtonStart: Button = findViewById(R.id.btnGetStarted)
        return mButtonStart
    }



    private fun hasReadeStoargePermissions(): Boolean {
        return EasyPermissions.hasPermissions(
            this,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        )
    }

    private fun readeSorageTask() {
        if (hasReadeStoargePermissions()) {
            mButtonStart().isEnabled = true

        } else {
            EasyPermissions.requestPermissions(
                this,
                "this app need to access stoarge",
                READ_S,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

//   fun insertDataToRoom(category: Categories?) {
//
//        GlobalScope.launch {
//            this.let {
            //  RecipeDatabase.getData(this@SplashActivity).recipeDao().clearDb()
//                for (arr in category!!.categorieitems) {
//                    RecipeDatabase.getData(this@SplashActivity).recipeDao().insertCategory(arr)
//                }
//            }
//            withContext(Dispatchers.Main) {
//                btnGetStarted.visibility = View.VISIBLE
//            }
//        }




    fun showToast(context: Context, string: String) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }

    override fun onRationaleAccepted(requestCode: Int) {
        mButtonStart().isEnabled = true
        showToast(this, "onRationaleAccepted")

    }

    override fun onRationaleDenied(requestCode: Int) {
        showToast(this, "onRationaleDenied")
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        showToast(this, "onPermissionsGranted")
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        }
    }
}