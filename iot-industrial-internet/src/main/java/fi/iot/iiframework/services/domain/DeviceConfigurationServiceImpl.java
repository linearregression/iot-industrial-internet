/*
 * IoT - Industrial Internet Framework
 * Apache License Version 2.0, January 2004
 * Released as a part of Helsinki University
 * Software Engineering Lab in summer 2015
 */
package fi.iot.iiframework.services.domain;

import fi.iot.iiframework.daos.domain.DeviceConfigurationDAO;
import fi.iot.iiframework.domain.Device;
import fi.iot.iiframework.domain.DeviceConfiguration;
import fi.iot.iiframework.services.GenericHibernateService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeviceConfigurationServiceImpl extends GenericHibernateService<DeviceConfiguration, String> implements DeviceConfigurationService {

    DeviceConfigurationDAO configurationDAO;
    
    @Autowired
    public DeviceConfigurationServiceImpl(DeviceConfigurationDAO dao) {
        configurationDAO = dao;
        super.dao = dao;
    }

    @Override
    public List<DeviceConfiguration> getBy(Device device) {
        return configurationDAO.getBy(device);
    }

    @Override
    public List<DeviceConfiguration> getBy(int from, int to) {
        return configurationDAO.get(from, to);
    }

    @Override
    public List<DeviceConfiguration> getBy(int amount) {
        return configurationDAO.get(0, amount);
    }
    
}
