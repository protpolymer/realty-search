package ru.itpark.service;

import ru.itpark.domain.HouseRent;
import ru.itpark.repository.HouseRentRepository;

import java.util.Comparator;
import java.util.List;

public class HouseRentService {
    private HouseRentRepository repository;

    public HouseRentService(HouseRentRepository repository){
        this.repository = repository;
    }

    public  void add(HouseRent houseRent){
        repository.add(houseRent);
    }

    public List<HouseRent> getAll(){
        return repository.getAll();
    }

    public List<HouseRent> getSortedCost(Comparator<HouseRent> comparator){
        List<HouseRent> result = repository.getAll();
        result.sort(comparator);
        return result;
    }

    public HouseRentService getFilterDistrict(String district){
        HouseRentService result = new HouseRentService(new HouseRentRepository());
        for (HouseRent houseRent : repository.getAll()) {
            if(houseRent.getDistrict().equalsIgnoreCase(district)){
                result.add(houseRent);
            }
        }
        return result;
    }
}
