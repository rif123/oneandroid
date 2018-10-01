package id.pastakangen.com.pastakangen.core

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.TextView
import butterknife.BindView
import id.pastakangen.com.pastakangen.R
import id.pastakangen.com.pastakangen.event.SessionExpired
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

/**
 * Created by rifky on 30/09/18.
 */

open class CoreActivity: AppCompatActivity(), CoreContract.View{
    private val TAG_EXPIRED = "expired"
    private  val TAG_ERROR = "ERROR"

    @BindView(R.id.core_toolbar)
    @JvmField
    var mToolbar: Toolbar? = null

    @BindView(R.id.tv_menu_toolbar)
    @JvmField
    var mTvMenu: TextView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)

    }



    override fun setActionbar(showBack: Boolean, stringResource: Int) {
        setSupportActionBar(mToolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.title = ""
            mTvMenu?.setText(stringResource)
            actionBar.setDisplayHomeAsUpEnabled(showBack)
            if (showBack) {
                actionBar.setHomeAsUpIndicator(resources.getDrawable(R.drawable.back))
            }
        }
    }

    override fun setActionbar(showBack: Boolean, string: String) {
        setSupportActionBar(mToolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.title = ""
            mTvMenu?.setText(string)
            actionBar.setDisplayHomeAsUpEnabled(showBack)
            if (showBack) {
                actionBar.setHomeAsUpIndicator(resources.getDrawable(R.drawable
                        .back))
            }
        }
    }


    override fun showError(msg: String) {
        var actionDialog = supportFragmentManager.findFragmentByTag(TAG_ERROR)
        if(actionDialog == null) {
            // todo dialog
        }
    }

    override fun showTimeout() {
    }

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }

    fun logout() {
       // todo remoave all preference
    }

    @Subscribe
    open fun onEvent(sessionExpired: SessionExpired) {
        // todo session expired
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }


}