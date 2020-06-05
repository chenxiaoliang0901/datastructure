package com.study.leetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * leetcode 933 最近的请求次数
 *
 *写一个 RecentCounter 类来计算最近的请求。
 *
 * 它只有一个方法：ping(int t)，其中 t 代表以毫秒为单位的某个时间。
 *
 * 返回从 3000 毫秒前到现在的 ping 数。
 *
 * 任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
 *
 * 保证每次对 ping 的调用都使用比之前更大的 t 值。
 *
 */

/**
 *
 * 实现思路：我们只会考虑最近 3000 毫秒到现在的 ping 数，因此我们可以使用队列存储这些 ping 的记录。
 * 当收到一个时间 t 的 ping 时，我们将它加入队列，并且将所有在时间 t - 3000 之前的 ping 移出队列。

 *
 */
public class RecentCounter {
    private Queue<Integer> linkedList;

    public RecentCounter(){
        this.linkedList = new LinkedList();
    }
    public int ping(int t){
        linkedList.add(t);
        //linkedList.peek() 获取队列头部的元素
        while (linkedList.peek()<t-3000){
            linkedList.poll(); //移除队列的第一个元素
        }
        return linkedList.size();

    }

}
