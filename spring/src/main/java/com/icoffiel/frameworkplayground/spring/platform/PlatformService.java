package com.icoffiel.frameworkplayground.spring.platform;

import com.icoffiel.frameworkplayground.spring.platform.rest.PlatformRequest;
import com.icoffiel.frameworkplayground.spring.platform.rest.PlatformResponse;
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
        Platform platform = platformMapper.platformRequestToPlatform(platformRequest);
        return platformMapper.platformToPlatformResponse(platforms.save(platform));
    }

    public void delete(Integer id) {
        platforms.deleteById(id);
    }
}
