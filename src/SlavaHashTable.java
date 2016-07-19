import java.util.*;

public class SlavaHashTable<K, V> {

    // the size of the hash table
    private int size = 0;

    // ArrayLists of objects for keys and values
    private List<K> keys;
    private List<V> values;

    public SlavaHashTable(int s) {
        // save the size
        size = s;

        // create an arraylist for holding the values and keys
        values = new ArrayList<>(size);
        keys = new ArrayList<>(size);

        // set each element to null
        for (int i = 0; i < size; i++) {
            values.add(null);
            keys.add(null);
        }
    }

    public int size() {
        return size;
    }

    public void insert(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("demo");
        }
        // find the index by calling the objects hashCode
        int index = key.hashCode() % size;

        // linear probe to find the next open space
        while (keys.get(index) != null) {
            index++;
            if (index >= size) {
                index = 0;
            }
        }

        // store it
        values.set(index, value);
        keys.set(index, key);
    }

    public Object lookup(K key) {

        if (key == null) {
            throw new IllegalArgumentException("demo");
        }

        int index = key.hashCode() % size;
        // linear probe to find the item

        while (!keys.get(index).equals(key)) {
            index++;
            if (index >= size) {
                index = 0;
            }
        }/*
        if (values.get(index) == null){
            return null;
        }*/
        return values.get(index);
    }
}

