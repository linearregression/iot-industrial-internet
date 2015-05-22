/*
 * IoT - Industrial Internet Framework
 * Apache License Version 2.0, January 2004
 * Released as a part of Helsinki University
 * Software Engineering Lab in summer 2015
 */
package fi.iot.iiframework.dataobject;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "datasource")
@Entity
@Table(name = "datasource")
public class DataSourceObject implements Serializable {    
    @XmlAttribute
    @Id
    protected String id;
    
    @XmlElement
    @Transient
    protected Header header;
    
    @XmlElementWrapper(name = "devices")
    @XmlElement(name = "device")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "SOURCE_DEVICES",
            joinColumns = @JoinColumn(name = "SOURCE_ID", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "DEVICE_ID", referencedColumnName="id")
    )
    protected List<Device> devices;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

}