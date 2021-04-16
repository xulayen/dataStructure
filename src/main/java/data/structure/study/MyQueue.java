package data.structure.study;

import java.util.LinkedList;

/**
 * 线性链表-
 * 队列
 */
public class MyQueue<T> {

    private LinkedList<T> list = new LinkedList<T>();

    /**
     * 入队
     * @param t
     * @return
     */
    public LinkedList<T> add(T t) {
        list.addLast(t);
        return list;
    }

    /**
     * 出队
     * @return
     */
    public T dequeue(){
        return list.removeFirst();
    }

}
