package yuliya.example.com.kotlindemo.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

/**
 * Created by yuliya on 08.09.17.
 */
class VKResponse {
    @SerializedName("response")
    @Expose
    var response: Response? = null


    inner class Response {

        @SerializedName("count")
        @Expose
        var count: Int = 0
        @SerializedName("items")
        @Expose
        var items: List<Item> = ArrayList()
            private set

        fun setItems() {
            this.items = items
        }

    }

    inner class Item {

        @SerializedName("id")
        @Expose
        var id: Int = 0
        @SerializedName("first_name")
        @Expose
        var firstName: String? = null
        @SerializedName("last_name")
        @Expose
        var lastName: String? = null
        @SerializedName("bdate")
        @Expose
        private val bdate: String? = null
        @SerializedName("photo_100")
        @Expose
        val photo100: String? = null
        @SerializedName("photo_max")
        @Expose
        var photomax: String? = null
        @SerializedName("hidden")
        @Expose
        private val hidden: Int = 0
        @SerializedName("deactivated")
        @Expose
        private val deactivated: String? = null

    }
}