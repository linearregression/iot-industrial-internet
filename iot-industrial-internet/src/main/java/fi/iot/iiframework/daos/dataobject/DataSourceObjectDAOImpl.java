/*
 * IoT - Industrial Internet Framework
 * Apache License Version 2.0, January 2004
 * Released as a part of Helsinki University
 * Software Engineering Lab in summer 2015
 */
package fi.iot.iiframework.daos.dataobject;

import fi.iot.iiframework.daos.GenericHibernateDAO;
import fi.iot.iiframework.dataobject.DataSourceObject;
import org.springframework.stereotype.Repository;

@Repository
public class DataSourceObjectDAOImpl
        extends GenericHibernateDAO<DataSourceObject, String>
        implements DataSourceObjectDAO {


}