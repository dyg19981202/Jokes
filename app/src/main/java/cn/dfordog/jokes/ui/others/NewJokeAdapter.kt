package cn.dfordog.jokes.ui.others

import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import cn.dfordog.jokes.R
import cn.dfordog.jokes.data.entity.Data
import cn.dfordog.jokes.data.entity.NewJokes
import cn.dfordog.jokes.data.entity.Result
import kotlinx.android.synthetic.main.item_new_jokes.view.*

class NewJokeAdapter(
    private val data: List<Data>
) : RecyclerView.Adapter<NewJokeAdapter.NewJokeViewHolder>() {

    inner class NewJokeViewHolder(view: View) : RecyclerView.ViewHolder(view)

//    private val differCallback = object : DiffUtil.ItemCallback<NewJokes>(){
//        override fun areItemsTheSame(oldItem: NewJokes, newItem: NewJokes): Boolean {
//            return oldItem.result == newItem.result
//        }
//
//        override fun areContentsTheSame(oldItem: NewJokes, newItem: NewJokes): Boolean {
//            return oldItem == newItem
//        }
//
//    }
//
//    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewJokeViewHolder {
        return NewJokeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_new_jokes,parent,false))
    }

    override fun onBindViewHolder(holder: NewJokeViewHolder, position: Int) {
//        val jokes = differ.currentList[position]
        val jokes = data[position]
        holder.itemView.apply {
            jokeContent.text = Html.fromHtml(jokes.content,FROM_HTML_MODE_LEGACY,null,null)
        }
    }

    override fun getItemCount(): Int {
//        return differ.currentList.size
        return data.size
    }

}