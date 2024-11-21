import java.util.ArrayList;

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

