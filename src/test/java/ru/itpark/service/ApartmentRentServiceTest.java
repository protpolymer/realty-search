package ru.itpark.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itpark.comparator.CostApartmentRentAscComparator;
import ru.itpark.domain.ApartmentRent;
import ru.itpark.repository.ApartmentRentRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentRentServiceTest {
    ApartmentRentService service;
    @BeforeEach
    void setUp(){
        ApartmentRentRepository repository = new ApartmentRentRepository();
        repository.add(new ApartmentRent(1, 100, 1, 1, 1, null, "Авиастроительный", 10_000, null, null));
        repository.add(new ApartmentRent(2, 100, 1, 1, 1, null, "Ново-Савиновский", 15_000, null, null));
        repository.add(new ApartmentRent(3, 100, 1, 1, 1, null, "Вахитовский", 30_000, null, null));
        repository.add(new ApartmentRent(4, 100, 1, 1, 1, null, "Авиастроительный", 12_000, null, null));
        service = new ApartmentRentService(repository);
    }

    @Test
    void addWithOneResult() {
        service.add(new ApartmentRent(5, 100, 1, 1, 1, null, "Авиастроительный", 12_000, null, null));
        assertEquals(5, service.getAll().size());
    }

    @Test
    void addWithMultipleResult() {
        service.add(new ApartmentRent(5, 100, 1, 1, 1, null, "Авиастроительный", 12_000, null, null));
        service.add(new ApartmentRent(6, 100, 1, 1, 1, null, "Авиастроительный", 12_000, null, null));
        assertEquals(6, service.getAll().size());
    }
    @Test
    void getAll() {
        assertEquals(4, service.getAll().size());
    }

    @Test
    void findByDistrictWithZeroResult() {
        {
            List<ApartmentRent> result = service.findByDistrict("Кировский");
            assertEquals(0, result.size());
        }
        {
            List<ApartmentRent> result = service.findByDistrict("Кировский", "Приволжский");
            assertEquals(0, result.size());
        }
    }
    @Test
    void findByDistrictWithOneResult() {
        List<ApartmentRent> result = service.findByDistrict("Вахитовский");
        assertEquals(1, result.size());
    }

    @Test
    void findByDistrictWithMultipleResult() {
        List<ApartmentRent> result = service.findByDistrict("Авиастроительный");
        assertEquals(2, result.size());
    }



}