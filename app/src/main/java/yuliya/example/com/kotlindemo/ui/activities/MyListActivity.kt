package yuliya.example.com.kotlindemo.ui.activities

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import android.os.Bundle
import android.support.v7.widget.PopupMenu
import android.view.View
import android.widget.Button
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import yuliya.example.com.kotlindemo.R
import yuliya.example.com.kotlindemo.models.VKResponse
import yuliya.example.com.kotlindemo.models.LastNameComparator
import yuliya.example.com.kotlindemo.models.UserIdComparator
import yuliya.example.com.kotlindemo.controllers.VKController
import java.util.*

class MyListActivity : AppCompatActivity() {


    internal var recyclerView: RecyclerView? = null
    private val users = ArrayList<VKResponse.Item>()
    internal var adapter = MyAdapter(this@MyListActivity, users)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mylist)

        val button = findViewById(R.id.buttonMenu) as Button
        button.setOnClickListener(viewClickListener)

        recyclerView = findViewById(R.id.my_recycler_view) as RecyclerView
        val layoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager

        var userid = "38593660"
        userid = intent.getStringExtra("User ID")


        VKController
                .vkApi?.VkontakteApi(userid, "bdate,photo_100,photo_max", "91b4df6991b4df6991b4df696e91e9260d991b491b4df69c8299d068e3ece0a09571e0a", "5.68", "en")?.enqueue(object : Callback<VKResponse> {
            override fun onResponse(call: Call<VKResponse>, response: Response<VKResponse>) {
                if (response.body().response != null) {
                    users.addAll(response.body()
                            .response!!
                            .items)
                    recyclerView!!.adapter = adapter
                } else if (response.body().response == null) {
                    Toast.makeText(this@MyListActivity, "Incorrect User ID", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MyListActivity, "Unknown error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<VKResponse>, t: Throwable) {
                //Retrofit errors
                Toast.makeText(this@MyListActivity, "An error occurred during networking", Toast.LENGTH_SHORT).show()
            }
        })
    }


    internal var viewClickListener: View.OnClickListener = View.OnClickListener { v -> showPopupMenu(v) }

    private fun showPopupMenu(v: View) {
        val popupMenu = PopupMenu(this, v)
        popupMenu.inflate(R.menu.popupmenu)
        popupMenu
                .setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.menu1 -> {
                            Collections.sort<VKResponse.Item>(users, LastNameComparator())
                            adapter.notifyDataSetChanged()
                            true
                        }
                        R.id.menu2 -> {
                            Collections.sort<VKResponse.Item>(users, UserIdComparator())
                            adapter.notifyDataSetChanged()
                            true
                        }
                        R.id.menu3 -> true
                        else -> false
                    }
                }
        popupMenu.show()
    }
}
