package com.ing.localisation.geolocalisation.controller;

import com.ing.localisation.geolocalisation.model.User;
import com.ing.localisation.geolocalisation.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class StartController {
    private static final Logger logger = LoggerFactory.getLogger(StartController.class);


    private UserService userService;

    public StartController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/geo")
    public String getGeo() throws Exception {
        String adress="10 Downing street 12333";
        String adres="25 Rue Balzac, 75008";
       return userService.getGeoPlaceApiResponse(adres) ;
    }


    @GetMapping("/testcaching")
    public User sayAWord(){

        logger.info(".... Fetching Users");
        logger.info("User-1 -->"  + userService.getUser("isbn-1234"));
        logger.info("User-1 --->" + userService.getUser("isbn-1234"));
        logger.info("User-1 --->" + userService.getUser("isbn-1234"));
        logger.info("User-1 --->" + userService.getUser("isbn-1234"));

        logger.info("User-2 -->"  + userService.getUser("isbn-4567"));
        logger.info("User-2 -->"  + userService.getUser("isbn-4567"));
        logger.info("User-2 -->"  + userService.getUser("isbn-4567"));
        logger.info("User-2 -->"  + userService.getUser("isbn-4567"));

        return userService.getUser("Mehenna-Missoum" );
    }
}
