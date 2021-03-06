package com.annimon.ownlang.modules.forms;

import com.annimon.ownlang.exceptions.TypeException;
import com.annimon.ownlang.lib.Arguments;
import static com.annimon.ownlang.lib.Converters.*;
import com.annimon.ownlang.lib.Function;
import com.annimon.ownlang.lib.FunctionValue;
import com.annimon.ownlang.lib.NumberValue;
import com.annimon.ownlang.lib.Types;
import com.annimon.ownlang.lib.Value;
import javax.swing.JTextField;

public class JTextFieldValue extends JComponentValue {

    private final JTextField textField;

    public JTextFieldValue(JTextField textField) {
        super(16, textField);
        this.textField = textField;
        init();
    }

    private void init() {
        set("onAction", new FunctionValue(this::addActionListener));
        set("addActionListener", new FunctionValue(this::addActionListener));
        set("getCaretPosition", voidToInt(textField::getCaretPosition));
        set("getColumns", voidToInt(textField::getColumns));
        set("getHorizontalAlignment", voidToInt(textField::getHorizontalAlignment));
        set("getSelectionEnd", voidToInt(textField::getSelectionEnd));
        set("getSelectionStart", voidToInt(textField::getSelectionStart));
        set("getScrollOffset", voidToInt(textField::getScrollOffset));
        set("getText", voidToString(textField::getText));
        set("setCaretPosition", intToVoid(textField::setCaretPosition));
        set("setColumns", intToVoid(textField::setColumns));
        set("setHorizontalAlignment", intToVoid(textField::setHorizontalAlignment));
        set("setScrollOffset", intToVoid(textField::setScrollOffset));
        set("setSelectionEnd", intToVoid(textField::setSelectionEnd));
        set("setSelectionStart", intToVoid(textField::setSelectionStart));
        set("setText", stringToVoid(textField::setText));
    }

    private Value addActionListener(Value... args) {
        Arguments.check(1, args.length);
        final int type = args[0].type();
        if (type != Types.FUNCTION) {
            throw new TypeException("Function expected, but found " + Types.typeToString(type));
        }
        final Function action = ((FunctionValue) args[0]).getValue();
        textField.addActionListener(e -> action.execute());
        return NumberValue.ZERO;
    }
}