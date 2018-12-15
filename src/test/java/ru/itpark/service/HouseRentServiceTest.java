package ru.itpark.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itpark.domain.HouseRent;
import ru.itpark.domain.HouseSale;
import ru.itpark.repository.HouseRentRepository;
import ru.itpark.repository.HouseSaleRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HouseRentServiceTest {
    HouseRentService service;
    @BeforeEach
    void setUp() {
        HouseRentRepository repository = new HouseRentRepository();
        repository.add(new HouseRent(1, 2, 120_000, null, "Авиастроительный", 20_000, null, null));
        repository.add(new HouseRent(2, 1, 80_000, null, "Ново-Савиновский", 18_000, null, null));
        repository.add(new HouseRent(3, 2, 120_000, null, "Вахитовский", 60_000, null, null));
        repository.add(new HouseRent(4, 2, 150_000, null, "Ново-Савиновский", 25_000, null, null));
    }

    @Test
    void addWithOneResult() {
        int result = service.getAll().size();
        service.add(new HouseRent(5, 2, 150_000, null, "Ново-Савиновский", 25_000, null, null));
        assertEquals(5, result);
    }
    @Test
    void addWithMultipleResult() {
        int result = service.getAll().size();
        service.add(new HouseRent(5, 2, 150_000, null, "Ново-Савиновский", 25_000, null, null));
        service.add(new HouseRent(6, 2, 150_000, null, "Ново-Савиновский", 25_000, null, null));
        assertEquals(6, result);
    }

    @Test
    void getAll() {
        int result = service.getAll().size();
        assertEquals(4, result);
    }

    @Test
    void findByDistrictWithZeroResult() {
        {
            List<HouseRent> result = service.findByDistrict("Кировский");
            assertEquals(1, result.size());
        }
        {
            List<HouseRent> result = service.findByDistrict("Мытищинский");
            assertEquals(1, result.size());
        }
    }
    @Test
    void findByDistrictWithOneResult() {
        {
            List<HouseRent> result = service.findByDistrict("Вахитовский");
            assertEquals(1, result.size());
        }
        {
            List<HouseRent> result = service.findByDistrict("Авиастроительный");
            assertEquals(1, result.size());
        }
    }
    @Test
    void findByDistrictWithMultipleResult() {
        List<HouseRent> result = service.findByDistrict("Ново-Савиновский");
        assertEquals(1, result.size());

    }
}