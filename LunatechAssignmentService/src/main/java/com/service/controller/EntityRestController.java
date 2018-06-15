package com.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.processor.BaseWrapperProcessor;

@RestController
@RequestMapping("/rest")
public class EntityRestController {

	@Autowired
	BaseWrapperProcessor processor;



	@RequestMapping(value = "/country/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity getEntityById(
			@PathVariable("code") String code) {

		return new ResponseEntity<>(processor.processGetEntityById(code), HttpStatus.OK);
	}

	@RequestMapping(value = "/{entity}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity getEntityById(@PathVariable("entity") String entity,
			@RequestParam("query") String query, @RequestParam("value") String value,
			@RequestParam("fuzzy") Boolean fuzzy) {

		String queryType = null;
		if (query != null && !query.isEmpty() && query.equalsIgnoreCase("code")) {
			queryType = "code";

		} else if (query != null && !query.isEmpty() && query.equalsIgnoreCase("name")) {
			queryType = "name";

		}
		return new ResponseEntity<>(processor.processQuery(entity, queryType, value, fuzzy), HttpStatus.OK);

	}

	@RequestMapping(value = "/reports/airportspercountry", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity noOfAirportsPerCountry(
			@RequestParam("order") String order,
			@RequestParam("value") String value) {

		return new ResponseEntity<>(processor.noOfAirportsPerCountry(order, value), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/reports/topcomUncomrunwayattribute", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity topCommonUncommonRunwayAttribute(
			@RequestParam("attribute") String attribute,
			@RequestParam("order") String order,
			@RequestParam("value") String value
			) {

		return new ResponseEntity<>(processor.topCommonUncommonRunwayAttribute(attribute,order, value), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/reports/runwaystypespercountry", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity getRunwayTypesPerCountry(@RequestParam("countrycode") String countrycode
			) {

		return new ResponseEntity<>(processor.getRunwayTypesPerCountry(countrycode), HttpStatus.OK);

	}

}