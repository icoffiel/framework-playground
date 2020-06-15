package com.icoffiel.frameworkplayground.spring.spring.platform;

import com.icoffiel.frameworkplayground.spring.spring.platform.rest.PlatformRequest;
import com.icoffiel.frameworkplayground.spring.spring.platform.rest.PlatformResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatformService {

    private final PlatformRepository platforms;
    private final PlatformMapper platformMapper;

    public PlatformService(PlatformRepository platforms, PlatformMapper platformMapper) {
        this.platforms = platforms;
        this.platformMapper = platformMapper;
    }

    public List<PlatformResponse> getAll() {
        return platforms
                .findAll()
                .stream()
                .map(platformMapper::platformToPlatformResponse)
                .collect(Collectors.toList());
    }

    public PlatformResponse save(PlatformRequest platformRequest) {
        Platform platform = new Platform(
                null,
                platformRequest.getName(),
                platformRequest.getReleaseDate(),
                platformRequest.getOwner()
        );
        Platform savedPlatform = platforms.save(platform);
        return platformMapper.platformToPlatformResponse(savedPlatform);
    }

    public void delete(Integer id) {
        platforms.deleteById(id);
    }
}
