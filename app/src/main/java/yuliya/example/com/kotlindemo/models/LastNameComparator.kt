package yuliya.example.com.kotlindemo.models

/**
 * Created by yuliya on 08.09.17.
 */
class LastNameComparator : Comparator<VKResponse.Item> {
    override fun compare(left: VKResponse.Item, right: VKResponse.Item): Int {
        return left.lastName!!.compareTo(right.lastName!!)
    }
}