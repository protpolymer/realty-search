package ru.itpark.repository;

import ru.itpark.domain.ApartmentRent;

import java.util.ArrayList;
import java.util.List;

public class ApartmentRentRepository {
    private List<ApartmentRent> itemsApartmentRent = new ArrayList<>();

    public void add(ApartmentRent apartmentRent){
        itemsApartmentRent.add(apartmentRent);
    }
    public List<ApartmentRent> getAll(){
        return itemsApartmentRent;
    }
}
