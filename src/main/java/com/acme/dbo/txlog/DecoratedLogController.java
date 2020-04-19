package com.acme.dbo.txlog;

public class DecoratedLogController extends LogController {


    private LogDecorator logDecorator;

    public DecoratedLogController(LogWriter logWriter, LogDecorator logDecorator) {
        super(logWriter);
        this.logDecorator = logDecorator;
    }

    @Override
    protected void writeAccordingBusinessRules(Command command) {
        logWriter.write(logDecorator.decorate(previousCommand));
    }

}
