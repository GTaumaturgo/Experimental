package br.unb.exp.PriorityQueueSizeLimited;

import java.util.TreeSet;

public class PriorityQueueSizeLimited<T> {
    TreeSet<T> set;
    int size;
    public PriorityQueueSizeLimited(int size){
        this.size = size;
        set = new TreeSet<T>();
    }


    public void add(T element){
        set.add(element);
        if(set.size() == size + 1)
            set.remove(set.last());
    }


    public T poll(){
        return set.pollFirst();
    }

    public int size() {
        return set.size();
    }
}
