package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.springbootdemo.dto.ItemDto;
import ru.itis.springbootdemo.dto.ItemForm;
import ru.itis.springbootdemo.services.ItemService;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;


    @PostMapping("/items/{company-id}/items")
    @ResponseBody
    public ItemDto addArticle(@PathVariable("company-id") Integer companyId, @RequestBody ItemForm itemForm) {
        return itemService.addItem(companyId, itemForm);
    }
}
