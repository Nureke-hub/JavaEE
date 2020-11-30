package Shop.Week8_Home_Task.services;

import Shop.Week8_Home_Task.entities.Brand;

import java.util.List;

public interface BranService {
    Brand addBrand(Brand brand);
    List<Brand> getAllBrands();
    Brand getBrand(Long id);
    void deleteBrand(Brand brand);
    Brand saveBrand(Brand brand);
}
