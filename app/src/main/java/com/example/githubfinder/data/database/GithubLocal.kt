package com.example.githubfinder.data.database

import android.util.Log
import androidx.paging.DataSource
import com.example.githubfinder.data.model.GitUserModel
import java.util.concurrent.Executor

class GithubLocal(
    private val userDao: UserDao, // interface defining db operation
    private val ioExecutor: Executor
) {

    /**
     * Insert a list of users in the database, on a background thread.
     */
    fun insert(users: List<GitUserModel>, insertFinished: () -> Unit) {
        ioExecutor.execute {
            Log.d("GithubLocal", "inserting ${users.size} users")
            userDao.insert(users)
            insertFinished()
        }
    }

    /**
     * Request a LiveData<List<User>> from the Dao, based on a User name. If the name contains
     * multiple words separated by spaces, then we're emulating the GitHub API behavior and allow
     * any characters between the words.
     * @param name user name
     */
    fun usersByName(name: String): DataSource.Factory<Int, GitUserModel> {
        // appending '%' so we can allow other characters to be before and after the query string
        val query = "%${name.replace(' ', '%')}%"
        return userDao.usersByName(query)
    }
}