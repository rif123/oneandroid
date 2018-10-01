package id.pastakangen.com.pastakangen.data

import android.content.Context
import com.iamhabib.easy_preference.EasyPreference
import id.pastakangen.com.pastakangen.entity.Profile

/**
 * Created by rifky on 30/09/18.
 */


class Preferences(val context: Context) {
    private val TAG_LOGIN_TOKEN = "login"

    private val TAG_TOKEN = "token"

    private val TAG_USER = "user"

    val getLoginToken : String?
        get() = EasyPreference.with(context).getString(TAG_LOGIN_TOKEN, "")

    val getToken : String?
        get() = EasyPreference.with(context).getString(TAG_TOKEN, "")

    fun saveLoginToken(login_token: String) {
        EasyPreference.with(context).addString(TAG_LOGIN_TOKEN, login_token).save()
    }

    fun saveToken(token: String) {
        EasyPreference.with(context).addString(TAG_TOKEN, token).save()
    }

    fun saveUser(user: Profile) {
        EasyPreference.with(context).addObject(TAG_USER, user).save()
    }

    val user: Profile?
        get() = EasyPreference.with(context).getObject(TAG_USER, Profile::class.java)

    fun removeAllPreference() {
        EasyPreference.with(context).clearAll().save()
    }
}