package Shop.Week8_Home_Task.services;

import Shop.Week8_Home_Task.entities.ShopItem;

import java.util.List;

public interface ItemService {
    ShopItem addItem(ShopItem item);
    List<ShopItem> getAllItems();
    List<ShopItem> getTopPageItems();
    List<ShopItem> findAllByName(String word);

    ShopItem getItem(Long id);
    void deleteItem(ShopItem item);
    ShopItem saveItem(ShopItem item);

    List<ShopItem> getItemsByNameAndBrandAsc(String word, Long id, double from, double to);
    List<ShopItem> getItemsByNameAndBrandDesc(String word, Long id, double from, double to);
    List<ShopItem> getItemsByNameAndBetweenPriceAsc(String word, double from, double to);
    List<ShopItem> getItemsByNameAndBetweenPriceDesc(String word, double from, double to);
    List<ShopItem> getItemsByBrandAndBetweenPriceAsc( Long id, double from, double to);
    List<ShopItem> getItemsByBrandAndBetweenPriceDesc( Long id, double from, double to);
    List<ShopItem> getItemsByBetweenPriceAsc(double from, double to);
    List<ShopItem> getItemsByBetweenPriceDesc(double from, double to);


}