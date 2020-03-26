package com.order.google.api;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

@Component
public class RequestErrorHandler implements ResponseErrorHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestErrorHandler.class);

	private JSONObject result;
	private boolean err;

	public JSONObject getResult() {
		return result;
	}

	@Override
	public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
		return (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
				|| httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
	}

	public boolean hasError() {
		return err;
	}

	@Override
	public void handleError(ClientHttpResponse httpResponse) throws IOException {
		err = true;
		StringWriter writer = new StringWriter();
		IOUtils.copy(httpResponse.getBody(), writer, StandardCharsets.UTF_8);
		JSONParser parser = new JSONParser();
		try {
			result = (JSONObject) parser.parse(writer.toString());
		} catch (ParseException e) {
			LOGGER.info("Unable to parse response body..");
		}
	}
}