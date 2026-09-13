package com.mitocode.controller;

import com.mitocode.dto.CategoryDTO;
import com.mitocode.dto.CategoryRecord;
import com.mitocode.model.Category;
import com.mitocode.service.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController{

    //@Autowired
    private final ICategoryService service;

    @Qualifier("categoryMapper")
    private final ModelMapper modelMapper;
//    private String text;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() throws Exception {

        //List<CategoryRecord> list = service.findAll().stream().map(e -> new CategoryRecord(e.getIdCategory(), e.getName(), e.getDescription(), e.isEnabled())).toList();
        //List<CategoryDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, CategoryDTO.class)).toList();
        List<CategoryDTO> list = service.findAll().stream().map(this::convertToDTO).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable("id") Integer id) throws Exception {
        Category obj = service.findById(id);

        return ResponseEntity.ok(convertToDTO(obj));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@Valid @RequestBody CategoryDTO dto) throws Exception {
        Category obj = service.save(convertToEntity(dto));

        return new ResponseEntity<>(convertToDTO(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody CategoryDTO dto) throws Exception {
//        dto.setIdCategory(id);
        Category obj = service.update(id, convertToEntity(dto));

        return new ResponseEntity<>(convertToDTO(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private CategoryDTO convertToDTO(Category obj) {
        return modelMapper.map(obj, CategoryDTO.class);
    }

    private Category convertToEntity(CategoryDTO dto) {
        return modelMapper.map(dto, Category.class);
    }


    /*public CategoryController(ICategoryService service) {
        this.service = service;
    }*/

    /*
    @GetMapping
    public Category getCategoryFull(){
        //service = new CategoryService();
        return service.getCategoryAndValidate(1);
    } */
}
