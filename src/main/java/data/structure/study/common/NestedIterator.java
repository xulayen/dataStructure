package data.structure.study.common;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    private Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nodeList) {
        List<Integer> result = new LinkedList<>();
        for(var node : nodeList){
            traverse(node,result);
        }
        this.it = result.iterator();
    }

    private void traverse(NestedInteger root, List<Integer> result) {

        if (root.isInteger()) {
            result.add(root.getInteger());
            return;
        }

        for (NestedInteger child : root.getList()) {
            traverse(child, result);
        }

    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return this.it.hasNext();
    }

    @Override
    public Integer next() {
        // TODO Auto-generated method stub
        return this.it.next();
    }

}