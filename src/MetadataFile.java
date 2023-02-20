public class MetadataFile {
    private String name;


    public MetadataFile(String name) {
        this.name = name;
    }

    public void open() {
        System.out.println("Opening file " + name);
    }

    public String getName() {
        return this.name;
    }
}
