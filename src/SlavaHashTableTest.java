import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SlavaHashTableTest {

    @Test
    public void size() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        SlavaHashTable<Integer, String > list = new SlavaHashTable<>(7);
        list.insert(15646, "One");
        list.insert(14565, "Two");
        list.insert(11354, "Three");
        list.insert(14856, "");
        list.insert(19413, "Four");
        assertEquals("One", list.lookup(15646));
        assertEquals("", list.lookup(14856));
        assertEquals(null, list.lookup(14857));
        assertEquals(7, list.size());

        try {
            assertEquals(null, list.lookup(null));
            list.insert(null, "null");
            list.insert(15616, null);

        } catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }

    @Test
    public void lookup() throws Exception {

    }
}
