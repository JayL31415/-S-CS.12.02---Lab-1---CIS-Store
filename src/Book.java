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
