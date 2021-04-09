package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dto.ItemDto;
import ru.itis.springbootdemo.dto.ItemForm;
import ru.itis.springbootdemo.dto.ItemPage;
import ru.itis.springbootdemo.services.ItemService;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/papers/search")
    public ResponseEntity<ItemPage> search(@RequestParam("size") Integer size,
                                           @RequestParam("page") Integer page,
                                           @RequestParam(value = "q", required = false) String query,
                                           @RequestParam(value = "sort", required = false) String sort,
                                           @RequestParam(value = "direction", required = false) String direction) {
        return ResponseEntity.ok(itemService.search(size, page, query, sort, direction));
    }

    @PostMapping("/items/{company-id}/items")
    @ResponseBody
    public ItemDto addArticle(@PathVariable("company-id") Integer companyId, @RequestBody ItemForm itemForm) {
        return itemService.addItem(companyId, itemForm);
    }
}
