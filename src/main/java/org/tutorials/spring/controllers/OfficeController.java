package org.tutorials.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tutorials.spring.model.entities.Address;
import org.tutorials.spring.model.entities.Company;
import org.tutorials.spring.model.entities.Office;
import org.tutorials.spring.model.repositories.CompanyRepository;
import org.tutorials.spring.model.repositories.OfficeRepository;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by mahsom on 3/24/16.
 */
@Controller
public class OfficeController {

    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @RequestMapping(value = "office.do", params = "add", method = RequestMethod.GET)
    public String getAddOffice(@RequestParam("company_id") long companyId, Model model) {
        model.addAttribute("company", companyRepository.findOne(companyId));
        return "office/add";
    }

    @RequestMapping(value = "office.do", params = "edit", method = RequestMethod.GET)
    public String getEditOffice(@RequestParam long id, Model model) throws IOException {
        model.addAttribute("office", officeRepository.findOne(id));
        return "office/edit";
    }

    @RequestMapping(value = "office.do", method = RequestMethod.GET)
    public String getViewOffice(@RequestParam long id, Model model) throws IOException {
        model.addAttribute("office", officeRepository.findOne(id));
        return "office/view";
    }

    @RequestMapping(value = "office.do", params = "add", method = RequestMethod.POST)
    public String postAddOffice(@RequestParam("company_id") long companyId,
                                @RequestParam String name,
                                @RequestParam String state,
                                @RequestParam String city,
                                @RequestParam String street,
                                @RequestParam String zip) {
        Address address = new Address(street, city, state, zip);
        Company company = companyRepository.findOne(companyId);
        Office office = new Office(name, address, company);
        officeRepository.save(office);
        return "redirect:office.do?id=" + office.getId();
    }

    @RequestMapping(value = "office.do", params = "edit", method = RequestMethod.POST)
    public String postEditOffice(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String state,
                                 @RequestParam String city,
                                 @RequestParam String street,
                                 @RequestParam String zip) {
        Office office = officeRepository.findOne(id);
        Address address = office.getAddress();
        office.setName(name);
        address.setState(state);
        address.setCity(city);
        address.setStreet(street);
        address.setZip(zip);
        officeRepository.save(office);
        return "redirect:office.do?id=" + office.getId();
    }


    @RequestMapping(value = "office.do", params = "delete", method = RequestMethod.POST)
    public String postOffice(@RequestParam long id) throws ServletException, IOException {
        Office office = officeRepository.findOne(id);
        officeRepository.delete(office);
        return "redirect:"+office.getCompany().getUrl();
    }
}
