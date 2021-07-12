package cn.dfordog.jokes.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cn.dfordog.jokes.data.repository.NewJokeRepository
import cn.dfordog.jokes.ui.viewmodels.NewJokesViewModel

class NewJokeViewModelProviderFactory(
    private val repository: NewJokeRepository
) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewJokesViewModel(repository) as T
    }
}