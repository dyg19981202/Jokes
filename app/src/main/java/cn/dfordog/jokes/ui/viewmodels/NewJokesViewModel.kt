package cn.dfordog.jokes.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cn.dfordog.jokes.data.entity.NewJokes
import cn.dfordog.jokes.data.repository.NewJokeRepository
import cn.dfordog.jokes.utils.Constants.Companion.JOKE_KEY
import cn.dfordog.jokes.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class NewJokesViewModel(private val newJokeRepository: NewJokeRepository) : ViewModel() {

    val newJokesLiveData = MutableLiveData<Resource<NewJokes>>()

    init {
        getNewJokesByNet(1,20,JOKE_KEY)
    }

    fun getNewJokesByNet(page: Int,pageSize: Int,key: String) = viewModelScope.launch(Dispatchers.IO) {
        newJokesLiveData.postValue(Resource.Loading())
        val response = newJokeRepository.getNewJokeFromNet(page = page,pagesize = pageSize,key = key)
        newJokesLiveData.postValue(handlerNewJokeResponse(response))
    }



    private fun handlerNewJokeResponse(response: Response<NewJokes>): Resource<NewJokes>{
        if(response.isSuccessful){
            response.body()?.let { resultResponse->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

}