package com.acme.dbo.txlog.commands;

 class CommandUtils {
    static boolean checkOverflow(int sum, int a, int b) {
        return (a > 0 && sum > b || a < 0 && sum < b);
    }
}
