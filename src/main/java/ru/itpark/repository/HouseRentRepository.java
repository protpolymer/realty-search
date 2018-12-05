package ru.itpark.repository;

import ru.itpark.domain.HouseRent;

import java.util.ArrayList;
import java.util.List;

public class HouseRentRepository {
    private List<HouseRent> itemsHousetRent = new ArrayList<>();

    public void add(HouseRent houseRent){
        itemsHousetRent.add(houseRent);
    }
    public List<HouseRent> getAll(){
        return itemsHousetRent;
    }
}
