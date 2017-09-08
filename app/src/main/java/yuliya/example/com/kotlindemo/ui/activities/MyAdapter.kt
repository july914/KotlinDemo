package yuliya.example.com.kotlindemo.ui.activities

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import yuliya.example.com.kotlindemo.R
import yuliya.example.com.kotlindemo.models.VKResponse

/**
 * Created by yuliya on 08.09.17.
 */
class MyAdapter (myListActivity: MyListActivity, private val users: List<VKResponse.Item>?) : RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.my_text_view, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.catImage.context
        holder.FirstName.text = users!![position].firstName
        holder.LastName.text = users[position].lastName
        Picasso.with(context).load(users[position].photo100).fit().error(android.R.drawable.stat_notify_error).into(holder.catImage)
        holder.catImage.tag = users[position].photo100
        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, UserDetailsActivity::class.java)
            intent.putExtra("Cat Name", holder.FirstName.text.toString())
            intent.putExtra("Cat Number", holder.LastName.text.toString())
            intent.putExtra("Cat Photo", users[position].photomax.toString())
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return users?.size ?: 0
    }

    class ViewHolder(var mTextView: View) : RecyclerView.ViewHolder(mTextView) {
        var FirstName: TextView
        var LastName: TextView
        var catImage: ImageView

        init {

            FirstName = mTextView.findViewById<TextView>(R.id.catTextView)
            LastName = mTextView.findViewById<TextView>(R.id.catNumber)
            catImage = mTextView.findViewById<ImageView>(R.id.imageView2)
            Picasso.with(mTextView.context).load(R.drawable.androidcat).fit().into(catImage)
        }
    }

}