package ru.itpark.domain;

public class HouseSale extends Realty {
    private int amountFloors;

    public HouseSale(int id, int amountFloors, int area, String settlement, String district, int cost, String owner, String description) {
        super(id, area, settlement, district, cost, owner, description);
        this.amountFloors = amountFloors;
    }

    public int getAmountFloors() {
        return amountFloors;
    }

    public void setAmountFloors(int amountFloors) {
        this.amountFloors = amountFloors;
    }

    @Override
    public String toString() {
        return "HouseSale{" +
                "amountFloors=" + amountFloors +
                ", id=" + getId() +
                ", area=" + getArea() +
                ", settlement='" + getSettlement() + '\'' +
                ", district='" + getDistrict() + '\'' +
                ", cost=" + getCost() +
                ", owner='" + getOwner() + '\'' +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
