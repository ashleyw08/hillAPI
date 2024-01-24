/*CRUD functions available to controller*/
package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IraSvc {
    
    @Autowired
    private IraRepository repository;
    
    public List<Ira> getAllIras() {
       
       return repository.findAll();
    }

    //need Ira obj
    public String addIra (Ira addingIra) {
        
        Ira newIra = new Ira( addingIra.getFirstName(),
            addingIra.getLastName(),
            addingIra.getIraName(),
            addingIra.getIraType());

        repository.save(newIra); //save obj to repo
        return newIra.getFirstName()+" "+newIra.getLastName();
    }

    //need Ira record
    public void updateIra(Ira ira) {
        if(repository.existsById(ira.getIraId())) {
            Optional<Ira> optionalIra = repository.findById(ira.getIraId());
            Ira revisedIra = optionalIra.get();
            revisedIra.setFirstName(ira.getFirstName());
            revisedIra.setLastName(ira.getLastName());
            revisedIra.setIraName(ira.getIraName());
            revisedIra.setIraType(ira.getIraType());

            repository.save(revisedIra);
        }
        else {
            System.out.println("Ira ID doesn't exist");
        }
    }

    public void deleteIra(int id) {
        if(repository.existsById(Integer.valueOf(id))){
            repository.deleteById(id);
        }
        else {
            System.out.println("Ira Id not found!");
        }
    }
}
