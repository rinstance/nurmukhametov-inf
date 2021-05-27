package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dto.ItemDto;
import ru.itis.springbootdemo.dto.ItemForm;
import ru.itis.springbootdemo.dto.ItemPage;
import ru.itis.springbootdemo.models.Item;
import ru.itis.springbootdemo.services.ItemService;

import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

//    @GetMapping("/items/search")
//    public ResponseEntity<ItemPage> search(@RequestParam("size") Integer size,
//                                           @RequestParam("page") Integer page,
//                                           @RequestParam(value = "q", required = false) String query,
//                                           @RequestParam(value = "sort", required = false) String sort,
//                                           @RequestParam(value = "direction", required = false) String direction) {
//        return ResponseEntity.ok(itemService.search(size, page, query, sort, direction));
//    }

    private String getAllItems(Model model) {
        model.addAttribute("itemsPage", itemService.getAll());
        return "all_items";
    }

    @GetMapping("/items")
    public String getAllItems(Model model, ItemPage itemPage) {
        if (itemPage.getSize() > 0 && itemPage.getPagesCount() >= 0) {
         return getSearchItems(model, itemPage.getSize(), itemPage.getPagesCount());
        }
        return getAllItems(model);
    }

    private String getSearchItems(Model model, int size, int page) {
        List<ItemDto> searchItems = itemService.search(size, page, null, "name", null).getItems();
        if (searchItems.isEmpty()) {
            return getAllItems(model);
        } else {
            model.addAttribute("itemsPage", itemService.mapToItems(searchItems));
            return "all_items";
        }
    }

    @CrossOrigin("http://localhost")
    @GetMapping("/items-js")
    public ResponseEntity<List<Item>> getAllItemsJs() {
        return ResponseEntity.ok(itemService.getAll());
    }

    @GetMapping("/items/search")
    public String search(@RequestParam("size") Integer size,
                                           @RequestParam("page") Integer page,
                                           @RequestParam(value = "q", required = false) String query,
                                           @RequestParam(value = "sort", required = false) String sort,
                                           @RequestParam(value = "direction", required = false) String direction,
                                           Model model) {
        model.addAttribute("itemList", itemService.search(size, page, query, sort, direction).getItems());
        return "items_page";
    }

    @PostMapping("/items/{company-id}/items")
    @ResponseBody
    public ItemDto addItem(@PathVariable("company-id") Integer companyId, @RequestBody ItemForm itemForm) {
        return itemService.addItem(companyId, itemForm);
    }
}
