package hu.cs.ex2.projectManagment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import hu.cs.ex2.projectManagment.dto.TypeDTO;

import hu.cs.ex2.projectManagment.model.Type;

import hu.cs.ex2.projectManagment.service.TypeService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@CrossOrigin
@RequestMapping("/api")
public class TypeController {


    @Autowired
    TypeService typeService;

     @GetMapping("/type/{id}/getOne")
    public ResponseEntity<TypeDTO> getTypeById(@PathVariable String id){
      
       return new ResponseEntity<>(typeService.convertToDTO(typeService.getTypeById(id)),HttpStatus.OK);

    }
 






    @PostMapping("/type/add")
     public ResponseEntity<TypeDTO> saveType(@RequestBody Type type){
    
        TypeDTO typeDTO=typeService.convertToDTO(typeService.addType(type));
        return new ResponseEntity<>(typeDTO,HttpStatus.CREATED);
     }


    @GetMapping("/type/getAll")
     public ResponseEntity<List<TypeDTO>> getAllTypes(){
     
        return new ResponseEntity<>(typeService.convertToDTO(typeService.getAllTypes()),HttpStatus.OK);
     }

     @GetMapping("/type/getAllIds")
     public ResponseEntity<List<String>> getTypeListIds(){
     

      List<String> a=typeService.getAllTypes().stream().map(t->t.getType()).collect(Collectors.toList());
        return new ResponseEntity<>(a,HttpStatus.OK);
     }



 

    @DeleteMapping("/type/{id}/delete")
    public void deleteTypeById(@PathVariable String id){
        
        typeService.deleteTypeById(id);
     }
    
    @PutMapping(value="type/update")
    public ResponseEntity<TypeDTO> edithType(@RequestBody Type type){
    
        TypeDTO typeDTO=typeService.convertToDTO(typeService.addType(type));
         return new ResponseEntity<>(typeDTO,HttpStatus.CREATED);
      }
     

    
}
