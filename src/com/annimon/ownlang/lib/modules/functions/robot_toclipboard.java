package com.annimon.ownlang.lib.modules.functions;

import com.annimon.ownlang.exceptions.ArgumentsMismatchException;
import com.annimon.ownlang.lib.Function;
import com.annimon.ownlang.lib.NumberValue;
import com.annimon.ownlang.lib.Value;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public final class robot_toclipboard implements Function {

    @Override
    public Value execute(Value... args) {
        if (args.length != 1) throw new ArgumentsMismatchException("One argument expected");
        
        Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(new StringSelection(args[0].asString()), null);
        return NumberValue.ZERO;
    }
}