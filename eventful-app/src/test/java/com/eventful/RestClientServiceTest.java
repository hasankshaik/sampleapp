package com.eventful;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by hshaik on 20/03/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class RestClientServiceTest {



    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private RestClientService restClientService =new RestClientService();

    @Before
    public void setUp() {
        restClientService.setAppKey("s");
        restClientService.setApiUrl("b");
    }

    @Test
    public void shouldReturnValueForLocationAndKeyWOrd() {
        when(restTemplate.getForObject("b&location=location&keywords=keywords&s",String.class)).thenReturn("SampleXml");
        assertTrue(restClientService.getStringDataSync("location","keywords").equals("SampleXml") );
    }

    @Test
    public void shouldReturnValueWithoutLocation() {
        when(restTemplate.getForObject("b&keywords=keywords&s",String.class)).thenReturn("SampleXml");
        assertTrue(restClientService.getStringDataSync("","keywords").equals("SampleXml") );
    }


    @Test
    public void shouldReturnValueWithoutKeyword() {
        when(restTemplate.getForObject("b&location=location&s",String.class)).thenReturn("SampleXml");
        assertTrue(restClientService.getStringDataSync("location","").equals("SampleXml") );
    }


    @After
    public void tearDown() {
        restClientService = null;
    }
}
