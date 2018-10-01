package id.pastakangen.com.pastakangen.core

/**
 * Created by rifky on 30/09/18.
 */

class CoreContract {
    interface View {
        fun setActionbar(showBack: Boolean, stringResource: Int)

        fun setActionbar(showBack: Boolean, string: String)

        fun showError(msg: String)

        fun showTimeout()

        fun showLoading()

        fun dismissLoading()
    }
}