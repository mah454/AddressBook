package org.tutorials.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tutorials.spring.model.entities.Company;
import org.tutorials.spring.model.repositories.CompanyRepository;

/**
 * Created by mahsom on 3/24/16.
 */
@Controller
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @RequestMapping(value = "company.do", method = RequestMethod.GET)
    public String getViewCompany(@RequestParam long id, Model model) {
        model.addAttribute("company", companyRepository.findOne(id));
        return "company/view";
    }

    @RequestMapping(value = "company.do", params = "add", method = RequestMethod.GET)
    public String getAddCompany() {
        return "company/add";
    }

    @RequestMapping(value = "company.do", params = "edit", method = RequestMethod.GET)
    public String getEditCompany(@RequestParam long id, Model model) {
        model.addAttribute("company", companyRepository.findOne(id));
        return "company/edit";
    }

    @RequestMapping(value = "company.do", params = "add", method = RequestMethod.POST)
    public String postAddCompany(@RequestParam String name) {
        Company company = new Company(name, null);
        companyRepository.save(company);
        return "redirect:company.do?id=" + company.getId();
    }

    @RequestMapping(value = "company.do", params = "edit", method = RequestMethod.POST)
    public String postEditCompany(@RequestParam long id,
                                  @RequestParam String name) {
        Company company = companyRepository.findOne(id);
        company.setName(name);
        companyRepository.save(company);
        return "redirect:company.do?id=" + company.getId();
    }

    @RequestMapping(value = "company.do", params = "delete", method = RequestMethod.POST)
    public String postDeleteCompany(@RequestParam long id) {
        companyRepository.delete(id);
        return "redirect:/contacts.do";
    }
}
