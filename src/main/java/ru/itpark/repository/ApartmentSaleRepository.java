package ru.itpark.repository;

import ru.itpark.domain.ApartmentSale;

import java.util.ArrayList;
import java.util.List;

public class ApartmentSaleRepository {
    private List<ApartmentSale> itemsApartmentSale = new ArrayList<>();

    public void add(ApartmentSale apartmentSale){
        itemsApartmentSale.add(apartmentSale);
    }
    public List<ApartmentSale> getAll(){
        return itemsApartmentSale;
    }
}
