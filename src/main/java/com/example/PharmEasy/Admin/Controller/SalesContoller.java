package com.example.PharmEasy.Admin.Controller;

import com.example.PharmEasy.Admin.Model.InventoryModel;
import com.example.PharmEasy.Admin.Service.InventoryInterface;
import com.example.PharmEasy.Admin.Service.SalesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.PharmEasy.Admin.Model.SalesModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Controller
public class SalesContoller {

    @Autowired
    SalesInterface salesInterface;
    @Autowired
    InventoryInterface inventoryInterface;

    @RequestMapping("/admin")
    public String adminsales(Model model) {
        List<SalesModel> salesModelList = salesInterface.findAll();
        model.addAttribute("salesdetaillist", salesModelList);

        List<InventoryModel> inventorymodellist = inventoryInterface.findAll();
        model.addAttribute("inventorylist", inventorymodellist);
        return "Admin";
    }

    @RequestMapping(value = "/saveinventory", method = RequestMethod.POST)
    public String editinventory(@ModelAttribute("inventory") InventoryModel inventoryModel) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        inventoryModel.setLastUpdated(dtf.format(now));
        inventoryInterface.save(inventoryModel);
        return "redirect:/admin";
    }

    @RequestMapping("/edit/{Id}")
    public ModelAndView editMedicineID(@PathVariable(name= "Id") String Id) {
        ModelAndView mav = new ModelAndView("EditInv");

        Optional<InventoryModel> inventoryModel = inventoryInterface.findById(Id);
        mav.addObject("inventoryModel", inventoryModel.get());
        return mav;
    }

    @RequestMapping("/delete/{Id}")
    public String deleteMedicineID(@PathVariable(name= "Id") String Id) {
        inventoryInterface.deleteById(Id);
        return "redirect:/admin";
    }

}
