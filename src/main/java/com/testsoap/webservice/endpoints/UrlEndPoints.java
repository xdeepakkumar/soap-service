package com.testsoap.webservice.endpoints;

import com.testsoap.webservice.service.CountryService;
import io.gigaforce.testsoap.webservice.Country;
import io.gigaforce.testsoap.webservice.GetCountryRequest;
import io.gigaforce.testsoap.webservice.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UrlEndPoints {

    @Autowired
    private CountryService countryService;

    private static final String NAMESPACE_URI = "http://gigaforce.io/testsoap/webservice";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest getCountryRequest){
        Country country = countryService.find(getCountryRequest.getName());
        GetCountryResponse countryResponse = new GetCountryResponse();
        countryResponse.setCountry(country);
        return countryResponse;
    }
}
