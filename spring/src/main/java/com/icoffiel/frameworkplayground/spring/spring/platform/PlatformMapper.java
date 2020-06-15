package com.icoffiel.frameworkplayground.spring.spring.platform;

import com.icoffiel.frameworkplayground.spring.spring.platform.rest.PlatformResponse;
import org.springframework.stereotype.Component;

@Component
public class PlatformMapper {

    public PlatformResponse platformToPlatformResponse(Platform platform) {
        return new PlatformResponse(
                platform.getId(),
                platform.getName(),
                platform.getReleaseDate(),
                platform.getOwner()
        );
    }
}
