package springboot2.springbootdemo2.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

import java.awt.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@org.springframework.boot.actuate.endpoint.annotation.Endpoint(id = "features")

public class FeatureEnpoints {

    private  final Map<String, Feature>  FeatureMap=
            new ConcurrentHashMap<>();

    public FeatureEnpoints() {
        FeatureMap.put("Department",new Feature(true));
        FeatureMap.put("User",new Feature(false));
        FeatureMap.put("Authentication",new Feature(false));

    }

    @ReadOperation
    public Map<String, Feature> getFeatureMap() {
        return FeatureMap;
    }

    @ReadOperation
    public  Feature feature(@Selector String fetureName)
    {
        return  FeatureMap.get(fetureName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature
    {
        private  boolean isEnabled;

    }

}
