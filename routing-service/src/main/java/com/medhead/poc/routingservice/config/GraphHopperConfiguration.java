package com.medhead.poc.routingservice.config;

import com.graphhopper.GraphHopper;
import com.graphhopper.config.CHProfile;
import com.graphhopper.config.Profile;
import com.graphhopper.util.GHUtility;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphHopperConfiguration {

    @Value("${graphhopper.osm-file}")
    private String osmFile;

    @Value("${graphhopper.graph-location}")
    private String graphLocation;

    @Bean
    public GraphHopper graphHopper() {

        GraphHopper hopper = new GraphHopper();

        hopper.setOSMFile(osmFile);
        hopper.setGraphHopperLocation(graphLocation);

        hopper.setEncodedValuesString(
                "car_access, car_average_speed, road_access, road_environment, max_speed, ferry_speed"
        );

        hopper.setProfiles(
                new Profile("car")
                        .setCustomModel(
                                GHUtility.loadCustomModelFromJar("car.json")
                        )
        );

        hopper.getCHPreparationHandler()
                .setCHProfiles(new CHProfile("car"));

        hopper.importOrLoad();

        return hopper;
    }
}