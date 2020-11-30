package Shop.Week8_Home_Task.Controllers;

import Shop.Week8_Home_Task.entities.Brand;
import Shop.Week8_Home_Task.entities.ShopItem;
import Shop.Week8_Home_Task.services.BranService;
import Shop.Week8_Home_Task.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller(value="/")
public class HomeController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private BranService branService;

    @GetMapping(value = "/")
    public String index(Model model){
        List<ShopItem> items = itemService.getTopPageItems();
        model.addAttribute("items", items);

        List<Brand> brands = branService.getAllBrands();
        model.addAttribute("brands", brands);
        return "index";
    }

    @GetMapping(value = "/all_items")
    public String all_items(Model model){
        List<ShopItem> items = itemService.getAllItems();
        model.addAttribute("items", items);

        List<Brand> brands = branService.getAllBrands();
        model.addAttribute("brands", brands);
        return "index";
    }

    @PostMapping(value = "/add_item")
    public String addTask(@RequestParam(name = "name", defaultValue = "No name") String name,
                          @RequestParam(name = "description", defaultValue = "No description") String description,
                          @RequestParam(name = "price", defaultValue = "0") int price,
                          @RequestParam(name = "amount", defaultValue = "0") int amount,
                          @RequestParam(name = "stars", defaultValue = "0") int stars,
                          @RequestParam(name = "small_url", defaultValue = "No url") String small_url,
                          @RequestParam(name = "large_url", defaultValue = "No url") String large_url,
                          @RequestParam(name = "added_date", defaultValue = "1970-01-01") java.sql.Date added_date,
                          @RequestParam(name = "brand_id", defaultValue = "1") Long brandId){

        Brand b = branService.getBrand(brandId);
        if(b != null){
            ShopItem item = new ShopItem(null, name, description, price, stars, amount, small_url, large_url, added_date, false, b);
            if(stars > 3){
                item.setInTopPage(true);
            }
            System.out.println(b.getName());
            itemService.addItem(item);
            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping(value = "/details/{id}")
    public String details(Model model, @PathVariable(name = "id") Long id){
        ShopItem item = itemService.getItem(id);
        model.addAttribute("item", item);
        return "details";
    }

    @GetMapping(value = "/searchByName")
    public String searchByName(Model model, @RequestParam(name = "word", defaultValue = "No name") String word){
        List<ShopItem> shopItems = itemService.findAllByName(word);
        model.addAttribute("items", shopItems);
        model.addAttribute("word", word);
        List<Brand> brands = branService.getAllBrands();
        model.addAttribute("brands", brands);
        Brand b = null;
        model.addAttribute("selected_brand", b);
        return "SearchResults";
    }

    @GetMapping(value = "/search")
    public String search(Model model,
                         @RequestParam(name = "word", defaultValue = "No name") String word,
                         @RequestParam(name = "brand_id", defaultValue = "0") Long brand_id,
                         @RequestParam(name = "price_from", defaultValue = "0") double price_from,
                         @RequestParam(name = "price_to", defaultValue = "1000000") double price_to
                         ){
        List<ShopItem> items = new ArrayList<>();
        if(brand_id != 0 && word.compareTo("No name") != 0 && branService.getBrand(brand_id) != null){
            items = itemService.getItemsByNameAndBrandAsc(word, brand_id, price_from, price_to);
            model.addAttribute("word", word);
            model.addAttribute("selected_brand", branService.getBrand(brand_id));
        }else if(brand_id == 0 && word.compareTo("No name") != 0){
            items = itemService.getItemsByNameAndBetweenPriceAsc(word, price_from, price_to);
            model.addAttribute("word", word);
        }else if(brand_id != 0 && word.compareTo("No name") == 0 && branService.getBrand(brand_id) != null){
            items = itemService.getItemsByBrandAndBetweenPriceAsc(brand_id, price_from, price_to);
            model.addAttribute("selected_brand", branService.getBrand(brand_id));
        }else if(brand_id == 0 && word.compareTo("No name") == 0){
            items = itemService.getItemsByBetweenPriceAsc(price_from, price_to);
        }
        List<Brand> brands = branService.getAllBrands();
        model.addAttribute("brands", brands);
        model.addAttribute("items", items);

        model.addAttribute("price_from", price_from);
        model.addAttribute("price_to", price_to);
        return "SearchResults";
    }

    @PostMapping(value = "/saveShopItem")
    public String saveShopItem(@RequestParam(name = "id", defaultValue = "0") Long id,
                          @RequestParam(name = "name", defaultValue = "No name") String name,
                          @RequestParam(name = "description", defaultValue = "No description") String description,
                          @RequestParam(name = "price", defaultValue = "0") int price,
                          @RequestParam(name = "amount", defaultValue = "0") int amount,
                          @RequestParam(name = "stars", defaultValue = "0") int stars,
                          @RequestParam(name = "small_url", defaultValue = "No url") String small_url,
                          @RequestParam(name = "large_url", defaultValue = "No url") String large_url,
                          @RequestParam(name = "added_date", defaultValue = "1970-01-01") java.sql.Date added_date){
        System.out.println("Hellooooooo");
        ShopItem item = itemService.getItem(id);
        if(item != null){
            item.setName(name);
            item.setDescription(description);
            item.setPrice(price);
            item.setAmount(amount);
            item.setStars(stars);
            item.setSmallPicURL(small_url);
            item.setLargePicURL(large_url);
            item.setAddedDate(added_date);
            if(stars > 3){
                item.setInTopPage(true);
            }else{
                item.setInTopPage(false);
            }
        }
        itemService.saveItem(item);
        return "redirect:/";
    }
}
