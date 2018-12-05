package ru.itpark.domain;

public class ApartmentRent extends ApartmentSale {

    public ApartmentRent(int id, int area, int floor, int maxFloor, int amountRooms, String settlement, String district, int cost, String owner, String description) {
        super(id, area, floor, maxFloor, amountRooms, settlement, district, cost, owner, description);
    }

}
