package id.pastakangen.com.pastakangen

import android.app.Application
import android.content.Context
import android.graphics.Typeface
import com.crashlytics.android.Crashlytics
import id.pastakangen.com.pastakangen.costum_overwrite.TypeFactory
import id.pastakangen.com.pastakangen.data.Preferences
import id.pastakangen.com.pastakangen.utils.ImageLoader
import io.fabric.sdk.android.Fabric

/**
 * Created by rifky on 29/09/18.
 */


class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // set config crashlytics
        if (!BuildConfig.DEBUG) {
            // For crashlytics
            Fabric.with(this, Crashlytics())
        }
        ImageLoader.initImageLoader(this)
    }

    companion  object {
        fun getTypeFace(context: Context, type: Int): Typeface {
            var mFontFactory: TypeFactory? = null
            if (mFontFactory == null)
                mFontFactory = TypeFactory(context)

            return when (type) {
                Constants.REGULAR -> mFontFactory.getRegular()
                Constants.BOLD -> mFontFactory.getBold()
                Constants.HEAVY -> mFontFactory.getHeavy()
                Constants.SEMIBOLD -> mFontFactory.getSemibold()
                else -> mFontFactory.getRegular()
            }
        }

        var mInstance: MainApplication? = null
        var preferences: Preferences? = null

    }

    interface Constants {
        companion object {
            const val REGULAR = 1
            const val BOLD = 2
            const val SEMIBOLD = 3
            const val HEAVY = 4
        }
    }

}