package com.tabac.egovernment.data.local

import android.content.Context
import androidx.core.content.edit

class Storage(context: Context): ISession {
    private val prefs = context.getSharedPreferences(STORAGE, Context.MODE_PRIVATE)

    override var token: String?
        get() = prefs.getString(TOKEN, null)
        set(value) = prefs.edit { putString(TOKEN, value) }
}

private const val STORAGE = "com.tabac.egovernment.storage"
private const val TOKEN = "$STORAGE.token"