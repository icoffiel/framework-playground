package com.icoffiel.frameworkplayground.spring.platform;

import com.icoffiel.frameworkplayground.spring.platform.rest.PlatformRequest;
import com.icoffiel.frameworkplayground.spring.platform.rest.PlatformResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public List<PlatformResponse> platformsToPlatformResponses(Set<Platform> platforms) {
        return platforms
                .stream()
                .map(this::platformToPlatformResponse)
                .collect(Collectors.toList());
    }

    public List<Platform> platformRequestsToPlatforms(List<PlatformRequest> platformRequests) {
        return platformRequests
                .stream()
                .map(this::platformRequestToPlatform)
                .collect(Collectors.toList());
    }

    public Platform platformRequestToPlatform(PlatformRequest platformRequest) {
        return new Platform(
                null,
                platformRequest.getName(),
                platformRequest.getReleaseDate(),
                platformRequest.getOwner(),
                new ArrayList<>()
        );
    }
}
