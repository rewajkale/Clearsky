package io.egen.api.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
 import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQueries({
	@NamedQuery(name="Record.findAll", query="SELECT r FROM Record r "),
	@NamedQuery(name="Record.findRecordedCities", query="SELECT DISTINCT r.city FROM Record r ORDER BY r.city ASC"),
	@NamedQuery(name="Record.findLatestWeather", query="SELECT r FROM Record r WHERE r.city=:pcity ORDER BY r.timestamp"),
	@NamedQuery(name="Record.hourlyAvgTemp", query="SELECT AVG(r.temperature) FROM Record r WHERE r.city=:pcity"),
	@NamedQuery(name="Record.dailyAvgWeather", query=" SELECT r.description FROM Record r WHERE r.city=:pcity")
})
public class Record {
	
	@Id
	private String recordId;
	@Column(nullable=false)
	private String city;
	@Column(nullable=false)
	private String description;
	private double humidity;
	private double pressure;
	@Column(nullable=false)
	private double temperature;
	@OneToOne
	private Wind wind;
	@Column(name="timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date timestamp;
	
	public Record(){
		this.recordId=UUID.randomUUID().toString();
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getTimestamp() {
		return timestamp;
	}
	
	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}
	

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Record [id=" + recordId + ", city=" + city + ", description=" + description + ", humidity=" + humidity
				+ ", pressure=" + pressure + ", temperature=" + temperature + ", wind=" + wind + ", timestamp="
				+ timestamp + "]";
	}
	
}

