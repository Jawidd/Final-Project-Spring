package hu.cs.ex2.projectManagment.service;

import java.util.List;

import hu.cs.ex2.projectManagment.dto.TypeDTO;
import hu.cs.ex2.projectManagment.model.Type;

public interface TypeService {
    public Type addType(Type type);
    
    public Type getTypeById(String id); 

    public TypeDTO convertToDTO(Type type);
  
    public List<TypeDTO> convertToDTO(List<Type> types);
    
    public List<Type> getAllTypes();
   
    public void deleteTypeById(String id);
    
}
