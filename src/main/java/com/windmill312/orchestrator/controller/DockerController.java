package com.windmill312.orchestrator.controller;

import com.windmill312.orchestrator.service.DockerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/docker")
public class DockerController {

    private final DockerService dockerService;

    public DockerController(DockerService dockerService) {
        this.dockerService = dockerService;
    }

    @GetMapping("/images")
    public String getImages() {
        return dockerService.getDockerImages();
    }

    @GetMapping
    public String getContainerLogs(@PathVariable String containerUid) {
        return dockerService.getContainerLogs(containerUid);
    }

    @PostMapping
    public String runContainer(@RequestBody String containerName) {
        return dockerService.runContainer(containerName);
    }
}
