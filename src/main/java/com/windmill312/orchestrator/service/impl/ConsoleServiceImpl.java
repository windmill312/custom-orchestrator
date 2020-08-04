package com.windmill312.orchestrator.service.impl;

import com.windmill312.orchestrator.model.ProcessInfo;
import com.windmill312.orchestrator.service.ConsoleService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ConsoleServiceImpl implements ConsoleService {

    public ProcessInfo executeCommand(String command, String... args) throws IOException {
        String[] runCommand = ArrayUtils.addFirst(args, command);
        UUID processUid = UUID.randomUUID();
        String logFileName = processUid + ".log";
        String fullLogFilePath = String.format("%s/%s", System.getProperty("user.home"), logFileName);

        Process process = new ProcessBuilder(runCommand)
                .redirectOutput(new File(fullLogFilePath))
                .start();
        return new ProcessInfo(process.pid(), processUid, fullLogFilePath, ArrayUtils.toString(runCommand));
    }
}
