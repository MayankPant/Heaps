import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
* This is a min heap implementation with a generic type
* */

public class Heap<T> {

    private List<T> heap;
    private Comparator<T> defaultComparator;

    Heap(Comparator<T> defaultComparator){
        heap = new ArrayList<>();
        this.defaultComparator  = defaultComparator;
    }


    public boolean add(T item){
        if(item == null)
            return false;
        try{

            heap.add(item);
            heapifyUp(heap.size() - 1);
            return true;

        }catch (Exception e){
            return false;
        }
    }


    public T remove(){
        if(heap.isEmpty())
            return null;
        swap(0, heap.size() - 1);
        T element = heap.remove(heap.size() - 1);
        heapifyDown(0);

        return  element;
    }

    public int size(){
        return heap.size();
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }

    private void heapifyUp(int index){
        if(index >= heap.size())
            return;
        if(index < 0)
            return;

        int parent = (index - 1)/2;
        int n = defaultComparator.compare(heap.get(index), heap.get(parent));
        if(n < 0){ // creating a min heap
            swap(parent, index);
            heapifyUp(parent);
        }
    }


    private void heapifyDown(int parent){

        if(parent >= heap.size())
            return;

        int leftChild;
        if(2 * parent + 1 < heap.size())
            leftChild = 2 * parent + 1;
        else
            leftChild = parent;

        int rightChild;
        if(2 * parent + 2 < heap.size())
            rightChild = 2 * parent + 2;
        else
            rightChild = parent;

        int n1 = defaultComparator.compare(heap.get(leftChild), heap.get(rightChild));
        int n2 = defaultComparator.compare(heap.get(parent), heap.get(leftChild));
        int n3 = defaultComparator.compare(heap.get(parent), heap.get(rightChild));

        if(n2 > 0 && n1 < 0){ // parent larger than left child and left child is smallest
            swap(parent, leftChild);
            heapifyDown(leftChild);
        }
        else if(n3 > 0 && n1 > 0){ // parent larger than right child and right child is smallest
            swap(parent, rightChild);
            heapifyDown(rightChild);
        }


    }

    private void swap(int parent, int index) {

        T temp = heap.get(parent);
        heap.set(parent, heap.get(index));
        heap.set(index, temp);
    }
}
