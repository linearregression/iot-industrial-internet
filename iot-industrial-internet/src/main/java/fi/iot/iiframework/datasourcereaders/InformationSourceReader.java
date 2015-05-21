/*
 * IoT - Industrial Internet Framework
 * Apache License Version 2.0, January 2004
 * Released as a part of Helsinki University
 * Software Engineering Lab in summer 2015
 */
package fi.iot.iiframework.datasourcereaders;

import fi.iot.iiframework.dataobject.DataObject;
import java.net.MalformedURLException;
import javax.xml.bind.JAXBException;

/**
 * Defines reader for a DataSource.
 * 
 */
public interface InformationSourceReader {
    public DataObject read() throws JAXBException, MalformedURLException;
}