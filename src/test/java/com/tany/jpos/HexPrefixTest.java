package com.tany.jpos;

import com.tany.jpos.interfaces.Prefix;
import com.tany.jpos.iso.ISORuntimeException;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.fail;

/**
 * @Author ThinkPad
 * @Since 1.0
 */
public class HexPrefixTest {
    @Test
    public void testPack(){
        int a = 0xef;
        Prefix prefix = new HexPrefix(3);
        Assert.assertArrayEquals(prefix.pack(a),new byte[]{0x00,(byte)0xef});
        prefix.setPrefixLen(2);
        Assert.assertArrayEquals(prefix.pack(a),new byte[]{(byte)0xef});
    }

    @Test
    public void testUnPack(){
        byte[] b = new byte[]{0x01,0x02,0x33,0x34,0x0F,0x32};
        Prefix prefix = new HexPrefix(2);
        Assert.assertEquals(prefix.unpack(b,1), 2);

        prefix = new HexPrefix(1);
        Assert.assertEquals(prefix.unpack(b,4), 15);

        prefix = new HexPrefix(3);
        Assert.assertEquals(prefix.unpack(b,1), 0x233);
        try{
            prefix.unpack(b,2);
            fail("超出长度没有判断");
        }catch (Exception e){
            Assert.assertTrue(e instanceof ISORuntimeException);
        }
    }
}
