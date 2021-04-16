package data.structure.study;

public class Node<T>{
    public T item;
    public Node<T> next;

    public Node(T element){
        this.item=element;
        this.next=null;

    }

}