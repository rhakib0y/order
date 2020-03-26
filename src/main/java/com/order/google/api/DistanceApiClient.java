package com.order.google.api;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.order.exception.OrderException;
import com.order.google.api.data.DistanceParams;

@Component
public class DistanceApiClient extends AbstractApiClient<Integer, DistanceParams> {

	@Value("${google.api.directions.url}")
	private String distanceApiUrl;

	@Value("${google.api.key}")
	private String apiKey;

	private static final String STATUS_OK = "OK";

	@Override
	public Integer get(DistanceParams args) {
		RestTemplate restTemplate = new RestTemplate();
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(distanceApiUrl);

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("origin", args.getOrigin());
		params.add("destination", args.getDestination());
		params.add("key", apiKey);
		uriBuilder.queryParams(params);

		HttpEntity<?> httpEntity = new HttpEntity<>(null, new HttpHeaders());
		JSONObject reponse = restTemplate.postForObject(uriBuilder.toUriString(), httpEntity, JSONObject.class);
		Integer result;
		String status = (String) reponse.get("status");
		if (StringUtils.equalsIgnoreCase(STATUS_OK, status)) {
			List<?> routes = (ArrayList<?>) reponse.get("routes");
			Map<?, ?> routesFirstIndex = (LinkedHashMap<?, ?>) routes.get(0);
			List<?> legs = (ArrayList<?>) routesFirstIndex.get("legs");
			Map<?, ?> legsFirstIndex = (LinkedHashMap<?, ?>) legs.get(0);
			Map<?, ?> distance = (LinkedHashMap<?, ?>) legsFirstIndex.get("distance");
			result = (Integer) distance.get("value");
		} else {
			throw new OrderException("Map latitude / longitude not found");
		}
		return result;
	}

	@Override
	public boolean isValid(DistanceParams args) {
		return false;
	}

}
