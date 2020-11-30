package Shop.Week8_Home_Task.services.impl;

import Shop.Week8_Home_Task.entities.ShopItem;
import Shop.Week8_Home_Task.repositories.ShopItemRepository;
import Shop.Week8_Home_Task.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ShopItemRepository shopItemRepository;

    @Override
    public ShopItem addItem(ShopItem item) {
        return shopItemRepository.save(item);
    }

    @Override
    public List<ShopItem> getAllItems() {
        return shopItemRepository.findAllByAmountGreaterThanOrderByPriceDesc(0);
    }

    @Override
    public ShopItem getItem(Long id) {
        return shopItemRepository.getOne(id);
    }

    @Override
    public void deleteItem(ShopItem item) {
        shopItemRepository.delete(item);
    }

    @Override
    public ShopItem saveItem(ShopItem item) {
        return shopItemRepository.save(item);
    }

    @Override
    public List<ShopItem> getTopPageItems(){
        return shopItemRepository.findAllByInTopPageIsTrueOrderByPriceDesc();
    }

    @Override
    public List<ShopItem> findAllByName(String word){
        return shopItemRepository.findAllByNameContainsOrderByPriceAsc(word);
    }

    @Override
    public List<ShopItem> getItemsByNameAndBrandAsc(String word, Long id, double from, double to) {
        return shopItemRepository.findAllByNameContainsAndBrandIdAndPriceBetweenOrderByPriceAsc(word, id, from, to);
    }

    @Override
    public List<ShopItem> getItemsByNameAndBrandDesc(String word, Long id, double from, double to) {
        return shopItemRepository.findAllByNameContainsAndBrandIdAndPriceBetweenOrderByPriceDesc(word, id, from, to);
    }

    @Override
    public List<ShopItem> getItemsByNameAndBetweenPriceDesc(String word, double from, double to) {
        return shopItemRepository.findAllByNameContainsAndPriceBetweenOrderByPriceDesc(word, from, to);
    }

    @Override
    public List<ShopItem> getItemsByNameAndBetweenPriceAsc(String word, double from, double to) {
        return shopItemRepository.findAllByNameContainsAndPriceBetweenOrderByPriceAsc(word, from, to);
    }

    @Override
    public List<ShopItem> getItemsByBrandAndBetweenPriceAsc(Long id, double from, double to) {
        return shopItemRepository.findAllByBrandIdAndPriceBetweenOrderByPriceAsc( id, from, to);
    }

    @Override
    public List<ShopItem> getItemsByBrandAndBetweenPriceDesc(Long id, double from, double to) {
        return shopItemRepository.findAllByBrandIdAndPriceBetweenOrderByPriceDesc( id, from, to);
    }

    @Override
    public List<ShopItem> getItemsByBetweenPriceAsc(double from, double to) {
        return shopItemRepository.findAllByPriceBetweenOrderByPriceAsc(from, to);
    }

    @Override
    public List<ShopItem> getItemsByBetweenPriceDesc(double from, double to) {
        return shopItemRepository.findAllByPriceBetweenOrderByPriceAsc( from, to);
    }
}
