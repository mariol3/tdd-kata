import it.addiction.learning.RecentlyUsedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mario Grimaldi <m.grimaldi@addiction.it> with <3
 */
public class RecentlyUsedListTest {

    private RecentlyUsedList list;

    @Before
    public void setUp() throws Exception {
        list = RecentlyUsedList.create();
    }

    @Test
    public void testNewListIsEmpty() throws Exception {
        assertEquals(0, list.size());
    }

    @Test
    public void testCannotInsertNullValues() throws Exception {
        testWordIsNotValid(null);
    }

    @Test
    public void testCannotInsertEmptyValues() throws Exception {
        testWordIsNotValid("");
    }

    private void testWordIsNotValid(String word) {
        try {
            list.insert(word);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void testLIFO() throws Exception {
        populateList();

        assertEquals("three", list.get());
    }

    private void populateList() {
        list.insert("one");
        list.insert("two");
        list.insert("three");
    }

    @Test
    public void testInsertingItemsChangesListSize() throws Exception {
        populateList();

        assertEquals(3, list.size());
    }

    @Test
    public void testGettingItemsChangeListSize() throws Exception {
        populateList();

        list.get();
        list.get();

        assertEquals(1, list.size());
    }

    @Test
    public void testLookupItemByIndex() throws Exception {
        populateList();

        assertEquals("two", list.lookupItemAt(1));
    }

    @Test
    public void testLookupDontChangeListSize() throws Exception {
        populateList();

        list.lookupItemAt(1);
        list.lookupItemAt(2);

        assertEquals(3, list.size());
    }

    @Test
    public void testDuplicateItemIsNotInserted() throws Exception {
        populateList();

        list.insert("one");

        assertEquals(3, list.size());
    }

    @Test
    public void testDuplicateItemMovesItemToTop() throws Exception {
        populateList();

        list.insert("one");

        assertEquals("one", list.get());
    }
}
