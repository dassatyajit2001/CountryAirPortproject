package com.service.util;

public interface IQueryConstants {
	String COUNTRY_QUERY_GET_BY_ID = "SELECT * FROM Country WHERE code = :code";
	String COUNTRY_AIRPORT_RUNWAY_QUERY_GET_BY_COUNTRY_CODE = "select c.id as countryId,c.code as countryCode,c.name as countryName,a.id as airportId\n"
			+ ",a.name as airportName,a.type as airportType\n" + ",r.id  as runwayId\n"
			+ "from country c,airport a,runway r where c.code=a.isocountry and a.ident=r.airportident and c.code=:code";

	String COUNTRY_AIRPORT_RUNWAY_QUERY_GET_BY_COUNTRY_NAME = "select c.id as countryId,c.code as countryCode,c.name as countryName,a.id as airportId\n"
			+ ",a.name as airportName,a.type as airportType\n" + ",r.id  as runwayId\n"
			+ "from country c,airport a,runway r where c.code=a.isocountry and a.ident=r.airportident and c.name like :name";

	String COUNTRY_NO_OF_AIRPORT_REPORT = "select c.code as countryCode,c.name as countryName,count(distinct a.ident)  countOfAirports "
			+ "from country c,airport a where c.code=a.isocountry group by c.code,c.name order by count(distinct a.ident)  sortOrder limit num";

	String RUNWAY_COMMON_UNCOMMON_REPORT = "select attribute,count(attribute) as counts from runway group by attribute order by count(attribute)  sortOrder limit num";
			//select c.code,count(distinct a.attribute) from country c,airport a where c.code=a.isocountry group by c.code order by count(distinct a.attribute) sortOrder limit num";

	String RUNWAYS_TYPES_PER_COUNTRY_REPORT="select c.code as countryCode,c.name as countryName, r.surface as runwaySurface from country c,airport a,runway r where c.code=a.isocountry and a.ident=r.airportident  and c.code=:countrycode group by  c.code,c.name,r.surface";
	
	String INSERT_COUNTRY_QUERY="insert into country1 values(:id,:code,:name,:continent,:wikipediaLink,:keywords)";
	String INSERT_AIRPORT_QUERY="insert into airport1 values(:id,:ident,:type,:name,:latitudeDeg,:longitudeDeg,:elevationFt,:continent,:isoCountry,:isoRegion,:municipality,:scheduledService,:gpsCode,:iataCode,:localCode,:homeLink,:wikipediaLink,:keywords)";
	String INSERT_RUNWAY_QUERY="insert into runway1 values(:id,:airportRef,:airportIdent,:lengthFt,:widthFt,:surface,:lighted,:closed,:leIdent,:leLatitudeDeg,:leLongitudeDeg,:leElevationFt,:leHeadingDegT,:leDisplacedThresholdFt,:heIdent,:heLatitudeDeg,:heLongitudeDeg,:heElevationFt,:heHeadingDegT,:heDisplacedThresholdFt)";
}
