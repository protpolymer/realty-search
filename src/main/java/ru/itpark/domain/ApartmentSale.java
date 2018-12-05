package ru.itpark.domain;

public class ApartmentSale extends Realty {
    private int floor;
    private int maxFloor;
    private int amountRooms;

    public ApartmentSale(int id, int area, int floor, int maxFloor, int amountRooms, String settlement, String district, int cost, String owner, String description) {
        super(id, area, settlement, district, cost, owner, description);
        this.floor = floor;
        this.maxFloor = maxFloor;
        this.amountRooms = amountRooms;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public int getAmountRooms() {
        return amountRooms;
    }

    public void setAmountRooms(int amountRooms) {

        this.amountRooms = amountRooms;
    }

    @Override
    public String toString() {
        return "ApartmentSale{" +
                "id=" + getId() +
                ", area=" + getArea() +
                ", floor=" + floor +
                ", maxFloor=" + maxFloor +
                ", amountRooms=" + amountRooms +
                ", settlement=" + getSettlement() +
                ", district=" + getDistrict() +
                ", cost=" + getCost() +
                ", owner=" + getOwner() +
                ", description" + getDescription() +
                '}';
    }
}

