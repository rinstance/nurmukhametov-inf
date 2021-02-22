package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.models.Company;
import ru.itis.springbootdemo.services.CompanyService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/companies_search", method = RequestMethod.GET)
    public String hello(Model model, @RequestParam(defaultValue = "") String searchName) {
        model.addAttribute("companies", companyService.getAll());
        return "companies_search";
    }

    @ResponseBody
    @GetMapping("/companies_search/{company-name}")
    public ResponseEntity<List<Company>> getByName(Model model, @PathVariable("company-name") String searchName) {
        List<Company> companies = companyService.getAll();
        List<Company> filterList = companies.stream()
                .filter(company -> company.getName().startsWith(searchName))
                .collect(Collectors.toList());
        model.addAttribute("companies", filterList);
        return ResponseEntity.ok(filterList);
    }
}
