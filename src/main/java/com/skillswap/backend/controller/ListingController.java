package com.skillswap.backend.controller;

import com.skillswap.backend.model.Listing;
import com.skillswap.backend.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/listing")
public class ListingController {
    @Autowired
    private ListingService listingService;

    @PostMapping("/add")
    public Listing addListing(@RequestParam Long userId,
                              @RequestParam String title,
                              @RequestParam String description,
                              @RequestParam double price,
                              @RequestParam String category) {
        return listingService.addListing(userId, title, description, price, category);
    }


    @GetMapping("/all")
        public List<Listing> getListings() {
        return listingService.getAllListings();
    }

    @GetMapping("{userId}")
    public List<Listing> getListingUser(@PathVariable Long userId) {
        return listingService.getListingsForUser(userId);
    }
}