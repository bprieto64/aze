
package projetwsClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import projetwsClient.api.MonsterGarageApi;
import projetwsClient.model.Voiture;

@Controller
public class VoituresController {

    @Autowired
    private MonsterGarageApi garageApi;

    @GetMapping("/voitures") 
    @ResponseBody
    public String list(Model model) {
       model.addAttribute("voiture", garageApi.getAll());
        return "/voitures";
    }  
    
//    @GetMapping("/")
//    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "srcview/voitures";
//    }

//    @GetMapping("/garage/{garageId}")
//    public String get(Model model, @PathVariable Integer garageId) {
//        model.addAttribute("garage", garageApi.get(garageId));
//        return "garage/show";
//    }
//
//    @GetMapping("/garage/new")
//    public String create(Model model) {
//        Garage garage = new Garage();
//        model.addAttribute("garage", garage);
//        return "garage/new";
//    }
//
//    @GetMapping("/garage/edit/{garageId}")
//    public String edit(Model model, @PathVariable Integer garageId) {
//        model.addAttribute("garage", garageApi.get(garageId));
//        return "garage/edit";
//    }
//
//    @PostMapping("/garage/add")
//    public String post(@ModelAttribute Garage garage) throws JsonProcessingException {
//        garageApi.create(garage);
//        return "redirect:/garage";
//    }
//
//    @PostMapping("/tuture")
//    public String put(@ModelAttribute Voiture voiture) throws JsonProcessingException {
//        garageApi.edit(voiture);
//        return "redirect:/voitures";
//    }
}

