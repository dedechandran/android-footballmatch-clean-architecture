package com.example.domain.common

import io.reactivex.subscribers.DisposableSubscriber

open class CustomSubscriber<T> : DisposableSubscriber<T>() {
    override fun onComplete() {
    }

    override fun onNext(data: T) {
    }

    override fun onError(t: Throwable?) {
    }
}