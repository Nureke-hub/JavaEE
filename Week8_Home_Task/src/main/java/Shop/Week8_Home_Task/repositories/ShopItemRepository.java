package Shop.Week8_Home_Task.repositories;

import Shop.Week8_Home_Task.entities.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface ShopItemRepository extends JpaRepository<ShopItem, Long> {
    List<ShopItem> findAllByAmountGreaterThanOrderByPriceDesc(int amount);

    List<ShopItem> findAllByNameContainsOrderByPriceAsc(String name);
    List<ShopItem> findAllByNameContainsOrderByPriceDesc(String name);

    List<ShopItem> findAllByPriceGreaterThanOrderByPriceAsc(double price);
    List<ShopItem> findAllByPriceGreaterThanOrderByPriceDesc(double price);

    List<ShopItem> findAllByPriceLessThanOrderByPriceAsc(double price);
    List<ShopItem> findAllByPriceLessThanOrderByPriceDesc(double price);

    List<ShopItem> findAllByNameContainsAndPriceGreaterThanOrderByPriceDesc(String name, double price);
    List<ShopItem> findAllByNameContainsAndPriceGreaterThanOrderByPriceAsc(String name, double price);

    List<ShopItem> findAllByNameContainsAndPriceLessThanOrderByPriceDesc(String name, double price);
    List<ShopItem> findAllByNameContainsAndPriceLessThanOrderByPriceAsc(String name, double price);

    List<ShopItem> findAllByNameContainsAndPriceBetweenOrderByPriceAsc(String name, double price1, double price2);
    List<ShopItem> findAllByNameContainsAndPriceBetweenOrderByPriceDesc(String name, double price1, double price2);

    List<ShopItem> findAllByInTopPageIsTrueOrderByPriceDesc();

    List<ShopItem> findAllByNameContainsAndBrandIdAndPriceBetweenOrderByPriceDesc(String name, Long id, double from, double to);
    List<ShopItem> findAllByNameContainsAndBrandIdAndPriceBetweenOrderByPriceAsc(String name, Long id, double from, double to);

    List<ShopItem> findAllByBrandIdAndPriceBetweenOrderByPriceDesc(Long id, double from, double to);
    List<ShopItem> findAllByBrandIdAndPriceBetweenOrderByPriceAsc(Long id, double from, double to);

    List<ShopItem> findAllByPriceBetweenOrderByPriceDesc(double from, double to);
    List<ShopItem> findAllByPriceBetweenOrderByPriceAsc(double from, double to);




}
