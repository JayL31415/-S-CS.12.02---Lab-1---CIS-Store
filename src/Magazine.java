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
