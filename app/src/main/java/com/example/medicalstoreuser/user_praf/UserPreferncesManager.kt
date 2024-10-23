package com.example.medicalstoreuser.user_praf


import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


private val Context.dataStore by preferencesDataStore("user_prefernces")

class UserPreferncesManager(private val context: Context) {

    companion object
    {
        private val User_ID_KEY = stringPreferencesKey("user_id")
    }


    suspend fun saveUserId(userId:String)
    {
        context.dataStore.edit {
            it[User_ID_KEY] = userId
        }
    }

    val userId : Flow<String?> = context.dataStore.data.map {
        it[User_ID_KEY]
    }

    suspend fun clearUserId()
    {
        context.dataStore.edit {
            it.remove(User_ID_KEY)
        }
    }

}