package ru.itpark.service;

import ru.itpark.domain.ApartmentRent;
import ru.itpark.repository.ApartmentRentRepository;

import java.util.Comparator;
import java.util.List;

public class ApartmentRentService {
    private ApartmentRentRepository repository;

    public ApartmentRentService(ApartmentRentRepository repository){
        this.repository = repository;
    }

    public void add(ApartmentRent apartmentRent){
        repository.add(apartmentRent);
    }

    public List<ApartmentRent> getAll(){
        return repository.getAll();
    }

    public List<ApartmentRent> getSortedCost(Comparator<ApartmentRent> comparator){
        List<ApartmentRent> result = repository.getAll();
        result.sort(comparator);
        return result;
    }
    public ApartmentRentService getApartmentRentFilterDistrict(String district){
        ApartmentRentService result = new ApartmentRentService(new ApartmentRentRepository());
        for (ApartmentRent apartmentRent : repository.getAll()) {
            if(apartmentRent.getDistrict().equalsIgnoreCase(district)){
                result.add(apartmentRent);
            }
        }
        return result;
    }
}
