package io.renren;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Arrays;


public class SplitTest {

    @Test
    public void splitTest(){
        String test="[\"http://pcwv3mgd3.bkt.clouddn.com/Fn6gcPj8Uiw03AVLGt39aguVx5di,\",\"http://pcwv3mgd3.bkt.clouddn.com/Fv-rhWFJlW_NhY6lgGHkXlGjGQMb,\",\"http://pcwv3mgd3.bkt.clouddn.com/Fv-rhWFJlW_NhY6lgGHkXlGjGQMb,\"]";
        String test1=test.replaceAll("[\\[\\]\\\"]", "");
        System.out.println(test1);
        String[] split = test.replaceAll("[\\[\\]\\\"]", "").split(",");
        System.out.println(Arrays.toString(split));
    }

    public static void main(String[] args) {
            String yzcmCZNvbXocrsz9dm8e = new Sha256Hash("admin",
                    "YzcmCZNvbXocrsz9dm8e").toHex();
            System.out.println(yzcmCZNvbXocrsz9dm8e);
    }

}
