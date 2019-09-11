package com.example.domain.common

import com.example.domain.PostExecutionThread
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

abstract class BaseFlowable<T, in Params>(private val postExecutionThread: PostExecutionThread) {
    private val compositeDisposable = CompositeDisposable()

    abstract fun build(params: Params): Flowable<T>

    fun execute(subscriber: DisposableSubscriber<T>, params: Params) {
        val disposable = build(params)
            .subscribeOn(Schedulers.io())
            .observeOn(postExecutionThread.getScheduler())
            .subscribeWith(subscriber)
        addDisposable(disposable)
    }

    fun dispose() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

    private fun addDisposable(disposable: Disposable?) {
        disposable?.let { compositeDisposable.add(it) }
    }
}