package com.example.shoestoreappudacitynanodegree.login

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private var loginList = HashMap<String, String>()


    init {
        userCredentials()
    }

    private fun userCredentials() {
        loginList["remmylawal@gmail.com"] = "2345"
    }

    fun verifyCredentials(email: String, password: String): Boolean {
        return loginList[email] == password
    }

    fun isUserAlreadyExisting(email: String): Boolean {
        return loginList.containsKey(email)
    }

    fun addCredentials(email: String, password: String) : Boolean {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            loginList[email] = password
            return true
        }
        return false
    }

}
