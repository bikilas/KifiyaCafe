package com.kifiya.service;

import com.kifiya.model.Food;
import com.kifiya.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    
    @Autowired
    private FoodRepository foodRepository;

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public Food getFoodById(Long id) {
        Optional<Food> food = foodRepository.findById(id);
        return food.orElse(null);
    }

    @Transactional
    public Food createFood(Food food) {
        return foodRepository.save(food);
    }

    @Transactional
    public Food updateFood(Long id, Food foodDetails) {
        Optional<Food> optionalFood = foodRepository.findById(id);
        if (optionalFood.isPresent()) {
            Food food = optionalFood.get();
            food.setName(foodDetails.getName());
            food.setDescription(foodDetails.getDescription());
            food.setPrice(foodDetails.getPrice());
            return foodRepository.save(food);
        }
        return null;
    }

    @Transactional
    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }

    public List<Food> searchFoods(String name, String category) {
        return foodRepository.findByNameContainingIgnoreCaseOrFoodCategory_NameContainingIgnoreCase(name, category);
    }

    public List<Food> getFoodsByCategory(Long categoryId) {
        return foodRepository.findByFoodCategory_Id(categoryId);
    }
}
