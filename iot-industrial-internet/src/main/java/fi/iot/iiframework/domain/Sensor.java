/*
 * IoT - Industrial Internet Framework
 * Apache License Version 2.0, January 2004
 * Released as a part of Helsinki University
 * Software Engineering Lab in summer 2015
 */
package fi.iot.iiframework.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "sensors")
@Data
@ToString(exclude = {"readouts", "source"})
public class Sensor implements Serializable {

    @Id
    @GeneratedValue
    protected Long id;

    @XmlAttribute(name = "name")
    protected String name;

    @JsonIgnore
    @OneToMany(mappedBy = "sensor", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @LazyCollection(LazyCollectionOption.EXTRA)
    protected Set<Readout> readouts;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source", nullable = false, updatable = false)
    protected InformationSource source;

    @XmlAttribute
    protected String quantity;

    @XmlAttribute
    protected String unit;

    protected boolean active;

    protected Double thresholdMax;

    protected Double thresholdMin;

    public Sensor() {
        active = true;
    }

    public Sensor(String name) {
        this.name = name;
    }

    protected void setReadouts(Set<Readout> readouts) {
        this.readouts = readouts;
    }

    protected Set<Readout> getReadouts() {
        return readouts;
    }

    @JsonProperty
    public long numberOfReadouts() {
        return readouts.size();
    }

    public Set<Readout> returnReadouts() {
        return Collections.unmodifiableSet(readouts);
    }

    public void addReadout(Readout readout) {
        if (readouts == null) {
            readouts = new HashSet<>();
        }
        readout.setSensor(this);
        readouts.add(readout);
    }

    public void addReadouts(Collection<Readout> readouts) {
        List<Readout> readoutsToAdd = new ArrayList<>();
        readouts.forEach(r -> readoutsToAdd.add(r));
        readoutsToAdd.forEach(r -> addReadout(r));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        if (this.source != null) {
            if (this.source.id != null) {
                hash = 97 * hash + Objects.hashCode(this.source.id);
            }
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sensor other = (Sensor) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return (this.source == null ? other.source == null : this.source.id.equals(other.source.id));
    }

}
