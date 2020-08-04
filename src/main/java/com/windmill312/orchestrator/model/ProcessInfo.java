package com.windmill312.orchestrator.model;

import java.util.UUID;

public class ProcessInfo {
    private final long processId;
    private final UUID processUid;
    private final String logFileName;
    private final String initText;

    public ProcessInfo(long processId, UUID processUid, String logFileName, String initText) {
        this.processId = processId;
        this.processUid = processUid;
        this.logFileName = logFileName;
        this.initText = initText;
    }

    public String getInitText() {
        return initText;
    }

    public long getProcessId() {
        return processId;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public UUID getProcessUid() {
        return processUid;
    }
}
