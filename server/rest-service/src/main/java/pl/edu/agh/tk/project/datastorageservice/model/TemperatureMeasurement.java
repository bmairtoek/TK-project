package pl.edu.agh.tk.project.datastorageservice.model;

import java.util.Date;

public class TemperatureMeasurement {
    private Date date;
    private Float value;
    private Float deviceId;


    @Override
    public String toString() {
        return "{date: " + this.date + ", temp: " + value + ", deviceId: " + deviceId + "}";
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Float getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Float deviceId) {
        this.deviceId = deviceId;
    }
}
