package com.mitocode.service.impl;

import com.mitocode.model.Category;
import com.mitocode.repo.ICategoryRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends CRUDImpl<Category, Integer> implements ICategoryService {

    //@Autowired
    private final ICategoryRepo repo;

    @Override
    protected IGenericRepo<Category, Integer> getRepo() {
        return repo;
    }

    /*
    @Override
    public Category save(Category category) throws Exception {
        return repo.save(category);
    }

    @Override
    public Category update(Integer id, Category category) throws Exception {
        category.setIdCategory(id);
        return repo.save(category);
    }

    @Override
    public List<Category> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Category findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Category());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    } */

    /*public CategoryServiceImpl(ICategoryRepo repo) {
        this.repo = repo;
    }*/

    /*
    @Override
    public Category getCategoryAndValidate(int id){
        if(id > 0){
            //repo = new CategoryRepo();
            return repo.getCategoryFromBD(id);
        }else{
            return new Category();
        }
    } */
}
