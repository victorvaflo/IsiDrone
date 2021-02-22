package entities;

public class Category {

    private int id,
            order,
            isActive;

    private String name,
            description;

    public Category() {
    }

    public Category(int id, String name, String description, int order, int isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.order = order;
        this.isActive = isActive;
    }

//    public Category(int i, String parameter, String parameter0, int parseInt, int parseInt0) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getIsActive() {
        return this.isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
