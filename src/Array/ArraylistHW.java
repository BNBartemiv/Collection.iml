package Array;

import java.util.Arrays;
import java.util.Collection;

public class ArraylistHW <T extends Comparable<T> > {
    private static final int cap = 10;
    private Object[] elements;
    private int size;

    public  ArraylistHW() {
        elements = new Object[cap];
        size = 0;
    }

    public void add(T element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    public T get (int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
        return (T) elements[index];
    }

    public T remove(int index){
        ensureExc(index);
        T removeElem = (T) elements[index];
        for (int i = index; i <size; i++){
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return removeElem;
    }

    public boolean addAll(Collection<? extends T> c) {
        ensureCapacity(size + c.size());
        for (T elemet : c) {
            elements[size++] = elemet;
        }
        return true;
    }

    private void ensureCapacity(int minCap) {
        if (minCap > elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }
    }

    private void ensureExc(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }

    public void sort() {
        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if (((T) elements[j]).compareTo((T) elements[j + 1]) > 0) {
                T temporary = (T) elements[j];
                elements[j] = elements[j + 1];
                elements[j + 1] = temporary;
                swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }



    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        for (int i = 0; i < size; i++) {
            string.append(elements[i]);
            if (i < size - 1) {
                string.append(", ");
            }
        }
        string.append("]");
        return  string.toString();
    }
}
