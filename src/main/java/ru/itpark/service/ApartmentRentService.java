package ru.itpark.service;

import ru.itpark.domain.ApartmentRent;
import ru.itpark.repository.ApartmentRentRepository;

import java.util.ArrayList;
import java.util.Arrays;
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
    public List<ApartmentRent> findByDistrict(String... districts){
        List<ApartmentRent> result = new ArrayList<>();
        List<String> districtsList = Arrays.asList(districts);
        for (ApartmentRent apartmentRent : repository.getAll()) {
            if(districtsList.contains(apartmentRent.getDistrict())){
                result.add(apartmentRent);
            }
        }
        return result;
    }
}
