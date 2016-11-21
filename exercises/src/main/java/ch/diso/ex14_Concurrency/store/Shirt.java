package ch.diso.ex14_Concurrency.store;

public class Shirt {

    private String id = "";
    private String description = "";
    private String color = "";
    private String size = "";

    public Shirt(String id, String description, String color, String size) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shirt ID: ")
                .append(getId())
                .append("\nDescription: ")
                .append(getDescription())
                .append("\nColor: ")
                .append(getColor())
                .append("\nSize: ")
                .append(this.getSize())
                .append("\n");

        return sb.toString();
    }
}