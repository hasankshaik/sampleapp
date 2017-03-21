package com.eventful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import static org.springframework.util.StringUtils.isEmpty;
import org.springframework.web.client.RestTemplate;


@Component
public class RestClientService {


    public static final String LOCATION = "&location=";
    public static final String KEYWORDS = "&keywords=";
    public static final String APPENDER = "&";


    @Value("${service.url}")
    private String apiUrl;

    @Value("${service.appkey}")
    private String appKey;

    @Autowired
    private RestTemplate restTemplate;

    public String getStringDataSync(String location, String keywords) {
        StringBuilder stringBuilder = new StringBuilder(apiUrl);
        if (!isEmpty(location)) {
            stringBuilder.append(LOCATION + location);
        }
        if (!isEmpty(keywords)) {
            stringBuilder.append(KEYWORDS + keywords);
        }
        stringBuilder.append(APPENDER);
        stringBuilder.append(appKey);
        String responseString = restTemplate.getForObject(stringBuilder.toString(), String.class);
        return responseString;
    }


    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
}
