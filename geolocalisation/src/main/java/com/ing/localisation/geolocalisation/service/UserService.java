package com.ing.localisation.geolocalisation.service;

import com.google.maps.FindPlaceFromTextRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.model.FindPlaceFromText;
import com.ing.localisation.geolocalisation.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Cacheable("users")
    public User getUser(String name ){
        simulateSlowService();
        return new User(1L,name, LocalDate.now());
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
    @Autowired
    GeoApiContext ctx;


    public String getGeoPlaceApiResponse(String address) throws Exception {

        String geoUrl =  "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=25%20Rue%20Balzac,%2075008&inputtype=textquery&fields=place_id,formatted_address,name,geometry";

        logger.info("GEO_CODE googleGeoPlace URL is: [{}] ", geoUrl);

        //FindPlaceFromText results1=   PlacesApi.findPlaceFromText(ctx, "fields=place_id,formatted_address,name,geometry", FindPlaceFromTextRequest.InputType.TEXT_QUERY).await();
        FindPlaceFromText results1=   PlacesApi.findPlaceFromText(ctx, "25%20Rue%20Balzac,%2075008&inputtype=textquery&fields=place_id,formatted_address,name,geometry", FindPlaceFromTextRequest.InputType.TEXT_QUERY).await();

        logger.info("GEO_CODE googleGeoPlace URL is: [{}] ", results1.candidates.length);
        return results1.toString();
    }
}
