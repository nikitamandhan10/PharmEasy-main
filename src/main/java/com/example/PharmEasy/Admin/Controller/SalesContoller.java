package com.example.PharmEasy.Admin.Controller;

import com.example.PharmEasy.Admin.Model.InventoryModel;
import com.example.PharmEasy.Admin.Service.InventoryInterface;
import com.example.PharmEasy.Admin.Service.InventorySearchRepository;
import com.example.PharmEasy.Admin.Service.SalesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;

import com.example.PharmEasy.Admin.Model.SalesModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Controller
public class SalesContoller {

    @Autowired
    SalesInterface salesInterface;
    @Autowired
    InventoryInterface inventoryInterface;

    @Autowired
    InventorySearchRepository inventorySearchRepository;

    @RequestMapping("/Sales")
    public String adminsales(Model model) {
        List<SalesModel> salesModelList = salesInterface.findAll();
        model.addAttribute("salesdetaillist", salesModelList);
        return "Sales";
    }

    @RequestMapping("/Inventory")
    public String listinventory(Model model) {
        List<InventoryModel> inventorymodellist = inventoryInterface.findAll();
        model.addAttribute("inventorylist", inventorymodellist);
        return "Inventory";
    }

    @RequestMapping("/AddInventory")
    public String addInventory(Model model) {
        return "AddInventory";
    }

    @RequestMapping(value = "/search")
    public String search(Model model, @RequestParam String search) {
        model.addAttribute("inventory",inventorySearchRepository.searchInventory(search));
        model.addAttribute("search",search);
        Collection<InventoryModel> collection = inventorySearchRepository.searchInventory(search);
        collection.forEach(inventoryModel -> System.out.println(inventoryModel));
        List<InventoryModel> inventorymodellist = inventoryInterface.findAll();
        model.addAttribute("inventorylist", inventorymodellist);
        return "Inventory";
    }

    @RequestMapping(value = "/saveinventory", method = RequestMethod.POST)
    public String editinventory(@ModelAttribute("inventory") InventoryModel inventoryModel, Model model) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        inventoryModel.setLastUpdated(dtf.format(now));
        inventoryInterface.save(inventoryModel);

        List<InventoryModel> inventorymodellist = inventoryInterface.findAll();
        model.addAttribute("inventorylist", inventorymodellist);
        return "Inventory";
    }

    @RequestMapping("/edit/{Id}")
    public ModelAndView editMedicineID(@PathVariable(name = "Id") String Id) {
        ModelAndView mav = new ModelAndView("EditInv");

        Optional<InventoryModel> inventoryModel = inventoryInterface.findById(Id);
        mav.addObject("inventoryModel", inventoryModel.get());
        return mav;
    }

    @RequestMapping("/delete/{Id}")
    public String deleteMedicineID(@PathVariable(name = "Id") String Id, Model model) {
        inventoryInterface.deleteById(Id);

        List<InventoryModel> inventorymodellist = inventoryInterface.findAll();
        model.addAttribute("inventorylist", inventorymodellist);
        return "Inventory";
    }
}
