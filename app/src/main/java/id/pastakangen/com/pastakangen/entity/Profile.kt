package id.pastakangen.com.pastakangen.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by rifky on 30/09/18.
 */

open class Profile {

    var id: Int? = 0

    @SerializedName("ramayana_id")
    var ramayanaId: String? = null

    var email: String? = null

    @SerializedName("full_name")
    var name: String? = null

    @SerializedName("dob")
    var birthdate: String? = null

    @SerializedName("identity_number")
    var identityNo : String? = null

    @SerializedName("phone_number")
    var phone : String? = null

    @SerializedName("card_image")
    var cardImage: String? = null

    @SerializedName("profile_image")
    var profileImage: String? = null

    @SerializedName("unread_notification")
    var notificationCount: Int? = 0

    var gender: String? = null

    var points: Int? = 0

    @SerializedName("user_role_id")
    var userRole: Int? = 0

    @SerializedName("activation_code")
    var activationCode: String? = null

    @SerializedName("is_activated")
    var isActivated: String? = null

    @SerializedName("created_at")
    var createdAt: String? = null

    @SerializedName("member_since")
    var memberSince: String? = null
}