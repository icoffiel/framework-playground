package com.icoffiel.frameworkplayground.spring.spring.platform;

import com.icoffiel.frameworkplayground.spring.spring.platform.rest.PlatformRequest;
import com.icoffiel.frameworkplayground.spring.spring.platform.rest.PlatformResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platforms")
public class PlatformController {

    private final PlatformService platformService;

    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @GetMapping
    public List<PlatformResponse> index() {
        return platformService.getAll();
    }

    @PostMapping
    public PlatformResponse addPlatform(@RequestBody PlatformRequest platformRequest) {
        return platformService.save(platformRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlatform(@PathVariable Integer id) {
        platformService.delete(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
