package com.acme.dbo.txlog;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DecoratedLogController extends LogController {

    private static final Logger LOG = Logger.getLogger(DecoratedLogController.class.getName());

    private LogDecorator logDecorator;

    public DecoratedLogController(LogWriter logWriter, LogDecorator logDecorator) {
        super(logWriter);
        this.logDecorator = logDecorator;
    }

    @Override
    protected void writeAccordingBusinessRules(Command command) {
        try {
            logWriter.write(logDecorator.decorate(previousCommand));
        } catch (LogException e) {
            LOG.log(Level.SEVERE, "unable to write/decorate log {}", command);
        }
    }

}
