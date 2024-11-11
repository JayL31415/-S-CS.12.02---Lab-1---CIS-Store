import java.util.ArrayList;

class CISItem {
    protected String title;
    protected String location;

    public CISItem(String title, String location) {
        this.title = title;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

class Book extends CISItem {
    private int wordCount;

    public Book(String title, String location, int wordCount) {
        super(title, location);
        this.wordCount = wordCount;
    }

    public int getWordCount() {
        return wordCount;
    }
}

class Phone extends CISItem {
    private String model;

    public Phone(String title, String location, String model) {
        super(title, location);
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

class Magazine extends CISItem {
    private String coverStory;

    public Magazine(String title, String location, String coverStory) {
        super(title, location);
        this.coverStory = coverStory;
    }

    public String getCoverStory() {
        return coverStory;
    }
}

class Store {
    private ArrayList<CISItem> cisItems;

    public Store() {
        cisItems = new ArrayList<>();
    }

    public void addBook(Book book) {
        cisItems.add(book);
    }

    public void addPhone(Phone phone) {
        cisItems.add(phone);
    }

    public void addMagazine(Magazine magazine) {
        cisItems.add(magazine);
    }

    public void updatePhonesLocation(String location) {
        for (CISItem item : cisItems) {
            if (item instanceof Phone) {
                item.setLocation(location);
            }
        }
    }

    public ArrayList<Phone> getAllPhones() {
        ArrayList<Phone> phones = new ArrayList<>();
        for (CISItem item : cisItems) {
            if (item instanceof Phone) {
                phones.add((Phone) item);
            }
        }
        return phones;
    }

    public ArrayList<CISItem> getItems(String itemType) {
        ArrayList<CISItem> items = new ArrayList<>();
        for (CISItem item : cisItems) {
            switch (itemType.toLowerCase()) {
                case "book":
                    if (item instanceof Book) items.add(item);
                    break;
                case "phone":
                    if (item instanceof Phone) items.add(item);
                    break;
                case "magazine":
                    if (item instanceof Magazine) items.add(item);
                    break;
            }
        }
        return items;
    }

    public void updateItems(String itemType, String property, String value) {
        for (CISItem item : cisItems) {
            if (itemType.equalsIgnoreCase("phone") && item instanceof Phone) {
                if (property.equalsIgnoreCase("location")) {
                    item.setLocation(value);
                }
            }

        }
    }

    public void showAllInfo() {
        for (CISItem item : cisItems) {
            System.out.println("Title: " + item.getTitle() + ", Location: " + item.getLocation());
        }
    }
}

class StoreTester {
    public static void main(String[] args) {
        Store store = new Store();

        Book book = new Book("Funny Book", "Shelf 1", 47000);
        store.addBook(book);
        assert true;


        Phone phone = new Phone("iPhone 13", "Display", "Apple");
        store.addPhone(phone);
        assert true;


        store.updatePhonesLocation("Room 512");
        for (Phone p : store.getAllPhones()) {
            assert p.getLocation().equals("Room 512");
        }


        ArrayList<CISItem> books = store.getItems("book");
        assert books.size() > 0;


        store.updateItems("phone", "location", "Room 511");
        for (Phone p : store.getAllPhones()) {
            assert p.getLocation().equals("Room 511");
        }
        
        store.showAllInfo();
    }
}