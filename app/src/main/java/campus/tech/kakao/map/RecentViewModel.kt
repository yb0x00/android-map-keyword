package campus.tech.kakao.map

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class RecentViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: RecentDataRepository = RecentDataRepository(application)

    private val _recentDataList = MutableLiveData<List<String>>()
    init {
        _recentDataList.value = repository.getSearchDataList()
    }

    fun addRecentData(data: String){
        val currentList = _recentDataList.value.orEmpty()
        if (data !in currentList){
            repository.insertSearchData(data)
            _recentDataList.value = repository.getSearchDataList()
        } }

    fun loadRecentData(): List<String> {
        return repository.getSearchDataList()
    }

    fun getRecentDataLiveData(): MutableLiveData<List<String>>{
        return _recentDataList
    }
}