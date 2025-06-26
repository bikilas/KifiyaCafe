// package com.kifiya.controller;

// import com.kifiya.dto.CafeDto;
// import com.kifiya.service.CafeService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/cafes")
// public class CafeController {

//     @Autowired
//     private CafeService cafeService;

//     @GetMapping
//     public List<CafeDto> getAllCafes() {
//         return cafeService.getAllCafes();
//     }

//     @GetMapping("/{id}")
//     public CafeDto getCafeById(@PathVariable Long id) {
//         return cafeService.getCafeById(id);
//     }

//     @PostMapping
//     // public CafeDto createCafe(@RequestBody CafeDto cafeDto) {
//         return cafeService.createCafe(cafeDto);
//     }

//     @PutMapping("/{id}")
//     public CafeDto updateCafe(@PathVariable Long id, @RequestBody CafeDto cafeDto) {
//         return cafeService.updateCafe(id, cafeDto);
//     }

//     @DeleteMapping("/{id}")
//     public void deleteCafe(@PathVariable Long id) {
//         cafeService.deleteCafe(id);
//     }

//     @GetMapping("/search")
//     public List<CafeDto> searchCafes(
//             @RequestParam(required = false) String name,
//             @RequestParam(required = false) String location,
//             @RequestParam(required = false) String type,
//             @RequestParam(required = false) Boolean hasWifi,
//             @RequestParam(required = false) Boolean hasParking,
//             @RequestParam(required = false) Boolean hasOutdoorSeating) {
//         return cafeService.searchCafes(name, location, type, hasWifi, hasParking, hasOutdoorSeating);
//     }
// }