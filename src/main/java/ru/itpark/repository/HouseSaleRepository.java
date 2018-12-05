package ru.itpark.repository;

import ru.itpark.domain.HouseSale;

import java.util.ArrayList;
import java.util.List;

public class HouseSaleRepository {
    private List<HouseSale> itemsHouseSale = new ArrayList<>();

    public void add(HouseSale houseSale) {
        itemsHouseSale.add(houseSale);
    }

    public List<HouseSale> getAll(){
        return itemsHouseSale;
    }
}
