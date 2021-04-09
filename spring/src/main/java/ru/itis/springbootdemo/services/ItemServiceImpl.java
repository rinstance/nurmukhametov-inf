package ru.itis.springbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ru.itis.springbootdemo.dto.ItemDto;
import ru.itis.springbootdemo.dto.ItemForm;
import ru.itis.springbootdemo.dto.ItemPage;
import ru.itis.springbootdemo.models.Company;
import ru.itis.springbootdemo.models.Item;
import ru.itis.springbootdemo.repositories.CompanyRepository;
import ru.itis.springbootdemo.repositories.ItemRepository;

import static ru.itis.springbootdemo.dto.ItemDto.from;

public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public ItemPage search(Integer size, Integer page, String query, String sortParameter, String directionParameter) {
        Sort.Direction direction = Sort.Direction.ASC;
        Sort sort = Sort.by(direction, "id");

        if (directionParameter != null) {
            direction = Sort.Direction.fromString(directionParameter);
        }

        if (sortParameter != null) {
            sort = Sort.by(direction, sortParameter);
        }

        if (query == null) {
            query = "empty";
        }

        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Item> papersPage = itemRepository.search(query, pageRequest);

        return new ItemPage(papersPage.getTotalPages(), from(papersPage.getContent()));
    }


    @Override
    public ItemDto addItem(Integer companyId, ItemForm itemForm) {
        Company company = companyRepository.getOne((long) companyId);

        Item newItem = new Item();
        newItem.setName(itemForm.getName());
        newItem.setImg(itemForm.getImg());
        newItem.setCount(itemForm.getCount());

        itemRepository.save(newItem);
        return from(newItem);
    }
}
