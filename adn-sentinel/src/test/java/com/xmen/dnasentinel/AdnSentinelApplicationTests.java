package com.xmen.dnasentinel;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdnSentinelApplicationTests {

    @Test
    void contextLoads() {
        String actual = "Hello Xmen";
        String expected = "Hello Xmen";
        Assert.assertEquals(actual,expected);
    }

}
