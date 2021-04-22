package hu.cs.ex2.projectManagment.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cs.ex2.projectManagment.dto.TypeDTO;
import hu.cs.ex2.projectManagment.model.Type;

import hu.cs.ex2.projectManagment.repository.TypeRepository;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeRepository typeRepository;
    
    @Autowired
    ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Type addType(Type type) {
        
        return typeRepository.save(type);
    }

    @Override
    public TypeDTO convertToDTO(Type type) {
        
        return modelMapper.map(type,TypeDTO.class);
    }

    @Override
    public List<TypeDTO> convertToDTO(List<Type> types) {

        List<TypeDTO> typeDTOList=new ArrayList<>();

        for(Type type:types){
            TypeDTO typeDTO =modelMapper.map(type, TypeDTO.class);

           // customerDTO.setInvoicesIds(customer.getInvoices().stream().map(invo->invo.getId()).collect(Collectors.toList()));
           // typeDTO.setProducts(customer.getInvoices().stream().map(invo->invo.getId()).collect(Collectors.toList()));
           typeDTO.setProducts(productService.convertToDTO(type.getProducts())); 

           typeDTOList.add(typeDTO);
        }
        
        return typeDTOList;
    }

    @Override
    public void deleteTypeById(String id) {
       typeRepository.deleteById(id);

    }

    @Override
    public List<Type> getAllTypes() {
        
        return typeRepository.findAll();
    }

    @Override
    public Type getTypeById(String id) {
        
        return typeRepository.getOne(id);
    }
    
}
