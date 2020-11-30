package Shop.Week8_Home_Task.services.impl;

import Shop.Week8_Home_Task.entities.Brand;
import Shop.Week8_Home_Task.repositories.BrandRepository;
import Shop.Week8_Home_Task.services.BranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BranService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand addBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getBrand(Long id) {
        return brandRepository.getOne(id);
    }

    @Override
    public void deleteBrand(Brand brand) {
        brandRepository.delete(brand);
    }

    @Override
    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }
}
