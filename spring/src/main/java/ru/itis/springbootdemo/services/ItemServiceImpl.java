package ru.itis.springbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.springbootdemo.dto.ItemDto;
import ru.itis.springbootdemo.dto.ItemForm;
import ru.itis.springbootdemo.models.Company;
import ru.itis.springbootdemo.models.Item;
import ru.itis.springbootdemo.repositories.CompanyRepository;
import ru.itis.springbootdemo.repositories.ItemRepository;

public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public ItemDto addItem(Integer companyId, ItemForm itemForm) {
        Company company = companyRepository.getOne((long) companyId);

        Item newItem = new Item();
        newItem.setName(itemForm.getName());
        newItem.setImg(itemForm.getImg());
        newItem.setCount(itemForm.getCount());

        itemRepository.save(newItem);
        return ItemDto.from(newItem);
    }
}
