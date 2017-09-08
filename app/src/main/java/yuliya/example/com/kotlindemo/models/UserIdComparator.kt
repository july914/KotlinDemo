package yuliya.example.com.kotlindemo.models

/**
 * Created by yuliya on 08.09.17.
 */
class UserIdComparator : Comparator<VKResponse.Item> {
    override fun compare(left1: VKResponse.Item, right1: VKResponse.Item): Int {
        return left1.id - right1.id
    }
}