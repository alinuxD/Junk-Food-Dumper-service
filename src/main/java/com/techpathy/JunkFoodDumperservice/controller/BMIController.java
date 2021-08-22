package com.techpathy.JunkFoodDumperservice.controller;

import com.techpathy.JunkFoodDumperservice.entity.BMI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@CrossOrigin
public class BMIController {
    @GetMapping("/api/getBMI")
    @ResponseBody
    public BMI getBMINum(@RequestParam(name = "height")String height,
                          @RequestParam(name = "weight") String weight,
                         @RequestParam(name = "hType",defaultValue = "cm") String hType,
                         @RequestParam(name = "wType",defaultValue = "kg") String wType){
        return new BMI( Double.parseDouble(height), Double.parseDouble(weight),hType,wType);
    }
}
