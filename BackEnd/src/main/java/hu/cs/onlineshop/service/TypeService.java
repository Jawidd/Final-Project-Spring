package hu.cs.onlineshop.service;

import java.util.List;

import hu.cs.onlineshop.dto.TypeDTO;
import hu.cs.onlineshop.model.Type;

public interface TypeService {
    public Type addType(Type type);
    
    public Type getTypeById(String id); 

    public TypeDTO convertToDTO(Type type);
  
    public List<TypeDTO> convertToDTO(List<Type> types);
    
    public List<Type> getAllTypes();
   
    public void deleteTypeById(String id);
    
}
