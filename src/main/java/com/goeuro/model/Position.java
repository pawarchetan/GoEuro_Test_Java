package com.goeuro.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sony on 3/22/2015.
 */
public class Position {
    @SerializedName("_type")
    @Expose
    private String typeName;

    @SerializedName("_id")
    @Expose
    private Integer id;
    @Expose
    private Object key;
    @Expose
    private String name;
    @Expose
    private String fullName;
    @SerializedName("iata_airport_code")
    @Expose
    private Object iataAirportCode;
    @Expose
    private String type;
    @Expose
    private String country;
    @SerializedName("geo_position")
    @Expose
    private GeoPosition geoPosition;
    @Expose
    private Integer locationId;
    @Expose
    private Boolean inEurope;
    @Expose
    private String countryCode;
    @Expose
    private Boolean coreCountry;
    @Expose
    private Object distance;

    /**
     * @return the typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the key
     */
    public Object getKey() {
        return key;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @return the iataAirportCode
     */
    public Object getIataAirportCode() {
        return iataAirportCode;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return the geoPosition
     */
    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    /**
     * @return the locationId
     */
    public Integer getLocationId() {
        return locationId;
    }

    /**
     * @return the inEurope
     */
    public Boolean getInEurope() {
        return inEurope;
    }

    /**
     * @return the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @return the coreCountry
     */
    public Boolean getCoreCountry() {
        return coreCountry;
    }

    /**
     * @return the distance
     */
    public Object getDistance() {
        return distance;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        if (country != null ? !country.equals(position.country) : position.country != null) return false;
        if (countryCode != null ? !countryCode.equals(position.countryCode) : position.countryCode != null)
            return false;
        if (fullName != null ? !fullName.equals(position.fullName) : position.fullName != null) return false;
        if (geoPosition != null ? !geoPosition.equals(position.geoPosition) : position.geoPosition != null)
            return false;
        if (id != null ? !id.equals(position.id) : position.id != null) return false;
        if (name != null ? !name.equals(position.name) : position.name != null) return false;
        if (type != null ? !type.equals(position.type) : position.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (geoPosition != null ? geoPosition.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "typeName='" + typeName + '\'' +
                ", id=" + id +
                ", key=" + key +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", iataAirportCode=" + iataAirportCode +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                ", geoPosition=" + geoPosition +
                ", locationId=" + locationId +
                ", inEurope=" + inEurope +
                ", countryCode='" + countryCode + '\'' +
                ", coreCountry=" + coreCountry +
                ", distance=" + distance +
                '}';
    }
}
