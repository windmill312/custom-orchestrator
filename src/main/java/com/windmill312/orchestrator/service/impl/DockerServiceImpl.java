package com.windmill312.orchestrator.service.impl;

import com.windmill312.orchestrator.model.ProcessInfo;
import com.windmill312.orchestrator.service.ConsoleService;
import com.windmill312.orchestrator.service.DockerService;
import com.windmill312.orchestrator.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DockerServiceImpl implements DockerService {

    private Logger logger = LoggerFactory.getLogger(DockerServiceImpl.class);

    private ConsoleService consoleService;
    private FileUtils fileUtils;

    private final String DOCKER_COMMAND = "docker";

    public DockerServiceImpl(ConsoleService consoleService, FileUtils fileUtils) {
        this.consoleService = consoleService;
        this.fileUtils = fileUtils;
    }

    public String getDockerImages() {
        try {
            ProcessInfo processInfo = consoleService.executeCommand(DOCKER_COMMAND, "images");
            String logFileName = processInfo.getLogFileName();
            return fileUtils.readOutputFile(logFileName);
        } catch (IOException e) {
            logger.error("Got error while getting docker images: ", e);
            return "ERROR";
        }
    }

    public String runContainer(String containerName) {
        try {
            ProcessInfo processInfo = consoleService.executeCommand(DOCKER_COMMAND, "run", containerName);
            return processInfo.getProcessUid().toString();
        } catch (IOException e) {
            logger.error(String.format("Got error while running docker container %s: ", containerName), e);
            return "ERROR";
        }
    }

    @Override
    public String getContainerLogs(String containerUid) {
        try {
            return fileUtils.readOutputFile(containerUid + ".log");
        } catch (IOException e) {
            logger.error("Got error while getting docker container logs: ", e);
            return "ERROR";
        }
    }
}
