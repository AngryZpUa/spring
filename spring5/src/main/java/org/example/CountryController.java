package org.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    @GetMapping("/france")
    public ResponseEntity<Country> france(){
        Country country = Country.of("france", 67);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "Europe")
                .header("capital", "Paris")
                .body(country);
    }

    @GetMapping("/all")
    public List<Country> all(){
        Country france = Country.of("france", 67);
        Country spain = Country.of("spain", 47);
        return List.of(france, spain);
    }

}
