package com.ing.localisation.geolocalisation;

import com.google.maps.GeoApiContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.net.InetSocketAddress;
import java.net.Proxy;

@SpringBootApplication
@EnableCaching
public class GeolocalisationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeolocalisationApplication.class, args);
	}

	@Bean
	public GeoApiContext getGeoApiContext() {
		return new GeoApiContext.Builder()
				.apiKey("AIzaSyB0VbF1IL2n3lAeeQUMeOjHpAQeyZVpVZE")

				.build();
	}

}

