package ru.itpark.service;

import ru.itpark.domain.HouseRent;
import ru.itpark.repository.HouseRentRepository;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<HouseRent> findByDistrict(String... districts){
        List<HouseRent> result = new ArrayList<>();
        List<String> districtList = Arrays.asList(districts);
        for (HouseRent houseRent : repository.getAll()) {
            if(districtList.contains(houseRent.getDistrict())){
                result.add(houseRent);
            }
        }
        return result;
    }
}
