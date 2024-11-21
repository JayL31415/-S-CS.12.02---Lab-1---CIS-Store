import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    private Store store;

    @BeforeEach
    public void setUp() {
        store = new Store();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Funny Book", "Shelf 1", 47000);
        store.addBook(book);
        assertTrue(store.getItems("book").size() > 0);
    }

    @Test
    public void testAddPhone() {
        Phone phone = new Phone("iPhone 13", "Display", "Apple");
        store.addPhone(phone);
        assertTrue(store.getAllPhones().size() > 0);
    }

    @Test
    public void testUpdatePhonesLocation() {
        Phone phone = new Phone("iPhone 13", "Display", "Apple");
        store.addPhone(phone);
        store.updatePhonesLocation("Room 512");
        for (Phone p : store.getAllPhones()) {
            assertEquals("Room 512", p.getLocation());
        }
    }

    @Test
    public void testGetItems() {
        Book book = new Book("Funny Book", "Shelf 1", 47000);
        store.addBook(book);
        ArrayList<CISItem> books = store.getItems("book");
        assertFalse(books.isEmpty());
    }

    @Test
    public void testUpdateItemsLocation() {
        Phone phone = new Phone("iPhone 13", "Display", "Apple");
        store.addPhone(phone);
        store.updateItems("phone", "location", "Room 511");
        for (Phone p : store.getAllPhones()) {
            assertEquals("Room 511", p.getLocation());
        }
    }

    @Test
    public void testShowAllInfo() {
        store.showAllInfo();
    }
}