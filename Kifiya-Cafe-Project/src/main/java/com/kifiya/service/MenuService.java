package com.kifiya.service;

import com.kifiya.model.Menu;
import com.kifiya.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    
    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getMenuById(Long id) {
        return menuRepository.findById(id);
    }

    @Transactional
    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Transactional
    public Optional<Menu> updateMenu(Long id, Menu menuDetails) {
        return menuRepository.findById(id)
            .map(menu -> {
                menu.setName(menuDetails.getName());
                menu.setDescription(menuDetails.getDescription());
                menu.setPrice(menuDetails.getPrice());
                menu.setAvailable(menuDetails.isAvailable());
                menu.setCategory(menuDetails.getCategory());
                menu.setCafe(menuDetails.getCafe());
                menu.setIngredients(menuDetails.getIngredients());
                return menuRepository.save(menu);
            });
    }

    @Transactional
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }

    public List<Menu> searchMenus(String name, String category) {
        return menuRepository.findByNameContainingIgnoreCaseOrCategory_NameContainingIgnoreCase(name, category);
    }
}
