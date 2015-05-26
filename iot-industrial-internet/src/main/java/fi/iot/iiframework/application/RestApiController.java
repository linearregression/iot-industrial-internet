/*
 * IoT - Industrial Internet Framework
 * Apache License Version 2.0, January 2004
 * Released as a part of Helsinki University
 * Software Engineering Lab in summer 2015
 */
package fi.iot.iiframework.application;

import fi.iot.iiframework.dataobject.DataSourceObject;
import fi.iot.iiframework.dataobject.Device;
import fi.iot.iiframework.dataobject.Header;
import fi.iot.iiframework.dataobject.Readout;
import fi.iot.iiframework.dataobject.Sensor;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("1.1")
public class RestApiController {

    @RequestMapping(value = "/datasources/list", produces = "application/json")
    @ResponseBody
    public List<DataSourceObject> listDatasources() {
        // TODO

        return null;
    }

    @RequestMapping(value = "/datasources/list/{amount}", produces = "application/json")
    @ResponseBody
    public List<DataSourceObject> listDatasourcesAmount(@PathVariable int amount) {
        try {
            // Hae tietokannasta ja palauta

        } catch (Exception ex) {
            // TODO Not found
        }

        return null;
    }

    @RequestMapping(value = "/datasources/list/{from}/{to}", produces = "application/json")
    @ResponseBody
    public List<DataSourceObject> listDatasourcesFromTo(@PathVariable int from, @PathVariable int to) {
        try {
            // Hae tietokannasta ja palauta

        } catch (NumberFormatException nfex) {
            // TODO Log error
        } catch (Exception ex) {
            // TODO Not found
        }

        return null;
    }

    @RequestMapping(value = "/datasources/{datasourceid}/view", produces = "application/json")
    @ResponseBody
    public DataSourceObject getDatasource(@PathVariable String datasourceid) {
        try {
            // Hae tietokannasta ja palauta

        } catch (Exception ex) {
            // TODO Not found
        }

        return null;
    }

    @RequestMapping(value = "/datasources/{datasourceid}/header", produces = "application/json")
    @ResponseBody
    public Header getDatasourceHeader(@PathVariable String datasourceid) {
        try {
            // Hae tietokannasta ja palauta

        } catch (Exception ex) {
            // TODO Not found
        }

        return null;
    }

    @RequestMapping(value = "/devices/{datasourceid}/list", produces = "application/json")
    @ResponseBody
    public List<Device> getDevices(@PathVariable String datasourceid) {
        try {
            // Hae tietokannasta ja palauta

        } catch (Exception ex) {
            // TODO Not found
        }

        return null;
    }

    @RequestMapping(value = "/devices/{datasourceid}/list/{amont}", produces = "application/json")
    @ResponseBody
    public List<Device> getDevicesAmount(@PathVariable String datasourceid, @PathVariable int amount) {
        try {
            // Hae tietokannasta ja palauta

        } catch (Exception ex) {
            // TODO Not found
        }

        return null;
    }

    @RequestMapping(value = "/devices/{datasourceid}/list/{from}/{to}", produces = "application/json")
    @ResponseBody
    public List<Device> getDevicesFromTo(@PathVariable String datasourceid, @PathVariable int from, @PathVariable int to) {
        try {
            // Hae tietokannasta ja palauta

        } catch (Exception ex) {
            // TODO Not found
        }

        return null;
    }

    @RequestMapping(value = "/devices/{deviceid}/view", produces = "application/json")
    @ResponseBody
    public Device getDevice(@PathVariable String deviceid) {
        try {
            // Hae tietokannasta ja palauta

        } catch (Exception ex) {
            // TODO Not found
        }

        return null;
    }

    @RequestMapping(value = "/sensors/{deviceid}/list/", produces = "application/json")
    @ResponseBody
    public List<Sensor> getSensor(@PathVariable String deviceid) {
        try {
            // Hae tietokannasta ja palauta

        } catch (Exception ex) {
            // TODO Not found
        }

        return null;
    }

    @RequestMapping(value = "/sensors/{deviceid}/list/{amont}", produces = "application/json")
    @ResponseBody
    public List<Sensor> getSensorAmount(@PathVariable String deviceid, @PathVariable int amount) {
        try {
            // Hae tietokannasta ja palauta

        } catch (Exception ex) {
            // TODO Not found
        }

        return null;
    }

    @RequestMapping(value = "/sensors/{deviceid}/list/{from}/{to}", produces = "application/json")
    @ResponseBody
    public List<Sensor> getSensorFromTo(@PathVariable String deviceid, @PathVariable int from, @PathVariable int to) {
        try {
            // Hae tietokannasta ja palauta

        } catch (Exception ex) {
            // TODO Not found
        }

        return null;
    }
    
    @RequestMapping(value = "/readouts/{sensorid}/list", produces = "application/json")
    @ResponseBody
    public List<Readout> getReadoutsList(@PathVariable String sensorid) {
        try {
            // Hae tietokannasta ja palauta

        } catch (Exception ex) {
            // TODO Not found
        }

        return null;
    }
    
    @RequestMapping(value = "/readouts/{sensorid}/list/{amont}", produces = "application/json")
    @ResponseBody
    public List<Readout> getReadoutsAmount(@PathVariable String sensorid, @PathVariable int amount) {
        try {
            // Hae tietokannasta ja palauta

        } catch (Exception ex) {
            // TODO Not found
        }

        return null;
    }

    @RequestMapping(value = "/readouts/{sensorid}/list/{from}/{to}", produces = "application/json")
    @ResponseBody
    public List<Sensor> getReadoutsFromTo(@PathVariable String sensorid, @PathVariable int from, @PathVariable int to) {
        try {
            // Hae tietokannasta ja palauta

        } catch (Exception ex) {
            // TODO Not found
        }

        return null;
    }
    
    @RequestMapping(value = "/readouts/{sensorid}/view/{timestamp}", produces = "application/json")
    @ResponseBody
    public Readout getReadout(@PathVariable String sensorid, @PathVariable String timestamp) {
        try {
            // Hae tietokannasta ja palauta

        } catch (Exception ex) {
            // TODO Not found
        }

        return null;
    }
    

}
