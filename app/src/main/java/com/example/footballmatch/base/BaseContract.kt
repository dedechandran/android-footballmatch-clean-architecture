package com.example.footballmatch.base

interface BaseContract {
    interface View{
        fun showSnackbar(message : String)
    }
    interface Presenter<in T>{
        fun onAttach(view : T)
        fun onDetach()
    }
}