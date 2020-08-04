package com.windmill312.orchestrator.service;

public interface DockerService {
    String getDockerImages();

    String runContainer(String containerName);

    String getContainerLogs(String containerUid);
}
