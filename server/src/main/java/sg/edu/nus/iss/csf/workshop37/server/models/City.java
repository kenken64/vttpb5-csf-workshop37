package sg.edu.nus.iss.csf.workshop37.server.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class City {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static City populate(ResultSet rs) 
        throws SQLException {
        City city = new City();
        city.setCode(rs.getString("code"));
        city.setName(rs.getString("city_name"));
        return city;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("code", getCode())
                .add("city_name", getName())
                .build();

    }

}
