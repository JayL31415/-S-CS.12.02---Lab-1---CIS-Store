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
