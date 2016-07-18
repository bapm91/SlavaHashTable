import java.util.*;

public class SlavaHashTable {

    public SlavaHashTable(int s) {
        // save the size
        size = s;

        // create an arraylist for holding the values and keys
        values = new ArrayList<Object>(size);
        keys = new ArrayList<Object>(size);

        // set each element to null
        for (int i = 0; i < size; i++) {
            values.add(null);
            keys.add(null);
        }
    }

    public void insert(Object key, Object value) {
        // find the index by calling the objects hashCode
        int index = key.hashCode() % size;

        // linear probe to find the next open space
        while (values.get(index) != null) {
            index++;
            if (index > size) {
                index = 0;
            }
        }

        // store it
        values.set(index, value);
        keys.set(index, key);
    }

    public Object lookup(Object key) {
        try {
            int index = key.hashCode() % size;

            // linear probe to find the item
            while (!keys.get(index).equals(key)) {
                index++;
                if (index > size) {
                    index = 0;
                }
            }

            return values.get(index);
        } catch (Exception e) {
            return null;
        }
    }

    // ArrayLists of objects for keys and values
    private ArrayList<Object> keys;
    private ArrayList<Object> values;

    // the size of the hash table
    private final int size;
}

