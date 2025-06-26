//package com.kifiya.service;
//
//import com.kifiya.dto.CafeDto;
//import com.kifiya.model.Cafe;
//import com.kifiya.repository.CafeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CafeService {
//
//    @Autowired
//    private CafeRepository cafeRepository;
//
//    public List<Cafe> getAllCafes() {
//        return cafeRepository.findAll();
//    }
//
//    public Optional<Cafe> getCafeById(Long id) {
//        return cafeRepository.findById(id);
//    }
//
//    @Transactional
//    public Cafe createCafe(Cafe cafe) {
//        return cafeRepository.save(cafe);
//    }
//
//    @Transactional
//    public Optional<Cafe> updateCafe(Long id, Cafe cafeDetails) {
//        return cafeRepository.findById(id)
//            .map(cafe -> {
//                cafe.setName(cafeDetails.getName());
//                cafe.setLocation(cafeDetails.getLocation());
//                cafe.setDescription(cafeDetails.getDescription());
//                cafe.setType(cafeDetails.getType());
//                cafe.setServiceType(cafeDetails.getServiceType());
//                cafe.setCapacity(cafeDetails.getCapacity());
//                // cafe.setHasOutdoorSeating(cafeDetails.getHasOutdoorSeating());
//                // cafe.setHasWifi(cafeDetails.getHasWifi());
//                // cafe.setHasParking(cafeDetails.getHasParking());
//                // cafe.setAcceptsReservations(cafeDetails.getAcceptsReservations());
//                // cafe.setIsPetFriendly(cafeDetails.getIsPetFriendly());
//                // cafe.setHasRestrooms(cafeDetails.getHasRestrooms());
//                // cafe.setHasPowerOutlets(cafeDetails.getHasPowerOutlets());
//                // cafe.setHasFoodMenu(cafeDetails.getHasFoodMenu());
//                // cafe.setHasCoffeeMenu(cafeDetails.getHasCoffeeMenu());
//                // cafe.setHasBakeryItems(cafeDetails.getHasBakeryItems());
//                // cafe.setHasVegetarianOptions(cafeDetails.getHasVegetarianOptions());
//                // cafe.setHasVeganOptions(cafeDetails.getHasVeganOptions());
//                // cafe.setHasGlutenFreeOptions(cafeDetails.getHasGlutenFreeOptions());
//                // cafe.setPhoneNumber(cafeDetails.getPhoneNumber());
//                cafe.setEmail(cafeDetails.getEmail());
//                cafe.setWebsite(cafeDetails.getWebsite());
//                cafe.setSocialMediaLinks(cafeDetails.getSocialMediaLinks());
//                cafe.setPaymentMethods(cafeDetails.getPaymentMethods());
//                cafe.setAverageRating(cafeDetails.getAverageRating());
//                cafe.setReviewCount(cafeDetails.getReviewCount());
//                // cafe.setIsOperational(cafeDetails.getIsOperational());
//                cafe.setOpeningTime(cafeDetails.getOpeningTime());
//                cafe.setClosingTime(cafeDetails.getClosingTime());
//                return cafeRepository.save(cafe);
//            });
//    }
//
//    @Transactional
//    public void deleteCafe(Long id) {
//        cafeRepository.deleteById(id);
//    }
//
//    public Collection<CafeDto> searchCafes(String name, String location, String type,
//            Boolean hasWifi, Boolean hasParking, Boolean hasOutdoorSeating) {
//        return cafeRepository.searchCafes(name, location, type, hasWifi, hasParking, hasOutdoorSeating);
//    }
//}