package com.tany.jpos.util;

import com.tany.jpos.NullPrefix;
import com.tany.jpos.interfaces.Prefix;

/**
 * @Author ThinkPad
 * @Since 1.0
 */
public class JPosUtils {
    public static final String UPPER_HEX_STR="0123456789ABCDEF";
    public static final String LOW_HEX_STR="0123456789ABCDEF";

    public static final Prefix NULL_PREFIX = new NullPrefix();
    public static final Prefix B = new NullPrefix();
}
