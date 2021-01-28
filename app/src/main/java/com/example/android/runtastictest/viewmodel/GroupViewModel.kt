package com.example.android.runtastictest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.runtastictest.data.GroupDataSet
import com.example.android.runtastictest.data.Result


class GroupViewModel: ViewModel() {

    private val groupDataSet = GroupDataSet()
    private val listData = MutableLiveData<Result>()

    init {
        getGroupList()
    }

    private fun getGroupList (){
        groupDataSet.getGroups(object:GroupDataSet.OnResultCallBack{
            override fun onResult(result: Result) {
                if(result is Result.Success){
                    val sortedList = result.list.sortedBy { it.members.size }
                    result.list= sortedList
                    listData.value = result
                }
            }
        })
    }
    fun getHouseListLiveData(): LiveData<Result> {
        return listData
    }
}