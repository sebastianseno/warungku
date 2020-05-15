package com.seno.bukawarungtest.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.seno.bukawarungtest.R
import com.seno.bukawarungtest.db.entity.UserDb
import com.seno.bukawarungtest.utils.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_user.view.*

class HomeAdapter (private val onClick: (Int) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items : List<UserDb> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_user))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ViewHolder)?.bind(items[position])
    }

    inner class ViewHolder (override val containerView: View):
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        init {
            containerView.setOnClickListener { onClick(items[adapterPosition].id) }
        }

        fun bind(userDb: UserDb) {
            itemView.apply {
                profilePicture.load(userDb.avatar)
                firstNameText.text = userDb.firstName
                lastNameText.text = userDb.lastName
                emailText.text = userDb.email
            }
        }
    }

}