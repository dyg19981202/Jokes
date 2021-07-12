package cn.dfordog.jokes.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import cn.dfordog.jokes.R
import cn.dfordog.jokes.data.db.AppDatabase
import cn.dfordog.jokes.data.entity.Result
import cn.dfordog.jokes.data.repository.NewJokeRepository
import cn.dfordog.jokes.ui.others.NewJokeAdapter
import cn.dfordog.jokes.ui.viewmodels.NewJokesViewModel
import cn.dfordog.jokes.utils.NewJokeViewModelProviderFactory
import cn.dfordog.jokes.utils.Resource
import kotlinx.android.synthetic.main.new_jokes_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class NewJokesFragment : Fragment() {

    companion object {
        fun newInstance() = NewJokesFragment()
    }

    private lateinit var viewModel: NewJokesViewModel
    private lateinit var adapter: NewJokeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.new_jokes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val db = AppDatabase(requireContext().applicationContext)
        val repository = NewJokeRepository(db)
        val factory = NewJokeViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this,factory).get(NewJokesViewModel::class.java)


        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.newJokesLiveData.observe(viewLifecycleOwner, Observer { response ->
                when(response){
                    is Resource.Success -> {
                        showJokeProgressBar.visibility = View.INVISIBLE
                        adapter = NewJokeAdapter(response.data!!.result.data)
                        newJokeRcv.adapter = adapter
                        newJokeRcv.layoutManager = LinearLayoutManager(context)

                    }
                }
            })
        }


    }

}