package com.ecommerce.shop.controllers.api.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTestBase
{
    @LocalServerPort
    private int port;

    protected TestRestTemplate getRestTemplate()
    {
        return new TestRestTemplate();
    }

    protected String getRootUrl()
    {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads()
    {
    }
}
