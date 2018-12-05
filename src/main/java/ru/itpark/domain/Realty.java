package ru.itpark.domain;

public abstract class Realty {
    private int id;
    private int area;
    private String settlement;
    private String district;
    private int cost;
    private String owner;
    private String description;

    public Realty(int id, int area, String settlement, String district, int cost, String owner, String description) {
        this.id = id;
        this.area = area;
        this.settlement = settlement;
        this.district = district;
        this.cost = cost;
        this.owner = owner;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Realty{" +
                "id=" + id +
                ", area=" + area +
                ", settlement='" + settlement + '\'' +
                ", district='" + district + '\'' +
                ", cost=" + cost +
                ", owner='" + owner + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

