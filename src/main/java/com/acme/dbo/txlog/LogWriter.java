package com.acme.dbo.txlog;

import com.acme.dbo.txlog.Command;

public interface LogWriter {
    void write (Command command);

}
