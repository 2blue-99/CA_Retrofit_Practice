package com.example.useapi.presenter

import androidx.lifecycle.SavedStateHandle
import com.example.useapi.domain.CoinsRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

class MainPresenter : MainContract.Presenter{

    override suspend fun getData(): List<CoinsModel> {
        return CoinsUseCase().getData()
    }

    override fun creat() {
        TODO("Not yet implemented")
    }

    override fun read() {
        TODO("Not yet implemented")
    }

    override fun update() {
        TODO("Not yet implemented")
    }


}