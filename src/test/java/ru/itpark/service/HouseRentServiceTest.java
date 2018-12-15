package ru.itpark.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itpark.domain.HouseRent;
import ru.itpark.repository.HouseRentRepository;

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
        service = new HouseRentService(repository);
    }

    @Test
    void addWithOneResult() {
        service.add(new HouseRent(5, 2, 150_000, null, "Ново-Савиновский", 25_000, null, null));
        int result = service.getAll().size();
        assertEquals(5, result);
    }
    @Test
    void addWithMultipleResult() {
        service.add(new HouseRent(5, 2, 150_000, null, "Ново-Савиновский", 25_000, null, null));
        service.add(new HouseRent(6, 2, 150_000, null, "Ново-Савиновский", 25_000, null, null));
        int result = service.getAll().size();
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
            assertEquals(0, result.size());
        }
        {
            List<HouseRent> result = service.findByDistrict("Мытищинский");
            assertEquals(0, result.size());
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
        assertEquals(2, result.size());

    }
}