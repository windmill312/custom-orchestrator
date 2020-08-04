package com.windmill312.orchestrator.service;

import com.windmill312.orchestrator.model.ProcessInfo;

import java.io.IOException;

public interface ConsoleService {
    ProcessInfo executeCommand(String command, String... args) throws IOException;
}
