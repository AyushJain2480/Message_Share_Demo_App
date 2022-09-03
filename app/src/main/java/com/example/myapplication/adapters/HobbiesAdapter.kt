package com.example.myapplication.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.models.Hobby
import com.example.myapplication.R
import com.example.myapplication.activities.SecondActivity
import com.example.myapplication.activities.showToast


//hv adapter super class
class HobbiesAdapter(private val context: Context, private val hobbies: List<Hobby>) :
    RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {


    companion object{
        val TAG : String = HobbiesAdapter::class.java.simpleName
    }


    //extend from RecyclerView.ViewHolder
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var currentHobby: Hobby? = null
        private var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {

                currentHobby?.let {
                    context.showToast(currentHobby!!.title + " Clicked !")
                }


            }
            itemView.findViewById<ImageView>(R.id.img).setOnClickListener {

                // our currentHobby object is not null
                // when this object is not null than execute my code
                currentHobby?.let{

                    val message = "My hobby is: " + currentHobby!!.title

                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type = "text/plain"
                    context.startActivity(Intent.createChooser(intent, "Please select app : "))


                }



            }
        }


        //hobby of the type nullable
        fun setData(hobby: Hobby?, pos: Int) {

            hobby?.let{
                // itemView is the whole box inside which we set the title of the textView
                itemView.findViewById<TextView>(R.id.tx_title).text = hobby.title

                this.currentHobby = hobby
                this.currentPosition = pos


            }

        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // it is simply responsible for creating each of the view Holder items
        // each of the listitem is viewHolder

        // this inflate method simply return this layout as a view
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)


        // returning the instance , object  of MyViewHolder class
        // MyViewHolder(itemView : View) this constructor is called so we have to pass the view when we call the object of myviewholder class
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // this method wil basically combine the data with the view so instead of title in list_item we get hobbies
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }

    override fun getItemCount(): Int {
        // responsible to return the length of this hobby list
        return hobbies.size
    }


}