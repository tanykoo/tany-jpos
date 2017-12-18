package com.tany.jpos.util;

import com.tany.jpos.util.StringUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author ThinkPad
 * @Since 1.0
 */
public class StringUtilsTest {

    @Test
    public void testbyte2hex(){
        byte[] b = new byte[]{0x01,0x00,(byte)0xf4,0x3F,(byte)0xa4};
        Assert.assertEquals(StringUtils.byte2hex(b),"0100F43FA4");
    }

    @Test
    public void testhex2byte(){
        String hex = "013456BDEDF230";
        Assert.assertArrayEquals(StringUtils.hex2byte(hex),new byte[]{0x01,0x34,0x56,(byte)0xbd,(byte)0xed,(byte)0xf2,0x30});
        String hex2 = "0013456BDEDF230";
        Assert.assertArrayEquals(StringUtils.hex2byte(hex2),new byte[]{0x00,0x01,0x34,0x56,(byte)0xbd,(byte)0xed,(byte)0xf2,0x30});
        String hex3 = "0013456BDEDa230";
        Assert.assertArrayEquals(StringUtils.hex2byte(hex3),new byte[]{0x00,0x01,0x34,0x56,(byte)0xbd,(byte)0xed,(byte)0xa2,0x30});

    }
}
