package com.anil.cryptocurrencycleanarchitecture.common

sealed class Resource<T>(val data:T?=null,val message:String?=null){

     class SUCCESS<T>(data: T?):Resource<T>(data = data)
     class LOADING<T>(data:T?=null):Resource<T>(data = data)
     class ERROR<T>(message: String?,data: T?=null):Resource<T>(message =message, data = data )

}