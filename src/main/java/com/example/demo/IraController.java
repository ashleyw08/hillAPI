/*Handling endpoints. Has to pass through service.*/
package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin //accessing api from Angular UI so need this annotation to tell api (different) external server needs access
@RequestMapping("/Iras")
public class IraController {

    @Autowired
    private IraSvc service;

    //mapping CRUD functions
    @GetMapping("/getAllIras")
    public List<Ira> getIras(){
        return service.getAllIras();
    }

    //coming from body of request. Must tell Spring API
    @PostMapping(path = "/ira/addnew")
    public void addIra(@RequestBody Ira ira) {
        service.addIra(ira);
    }

    //id is coming as request param (aka path variable)
    //need id of record to update and modifications made. coming as body of request. 
    @PutMapping(path = "/ira/{id}/edit")
    public void updateIra(@PathVariable("id") Integer id, @RequestBody Ira ira) {
        
        //don't need to pass id as param here. spring will know as it is in the path variable
        service.updateIra(ira); 
    }

    @DeleteMapping(path = "/ira/{id}/delete")
    public void deleteIra(@PathVariable("id") Integer id) {
        service.deleteIra(id);
    }
    
}
