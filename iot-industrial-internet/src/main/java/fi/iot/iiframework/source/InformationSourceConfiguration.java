/*
 * IoT - Industrial Internet Framework
 * Apache License Version 2.0, January 2004
 * Released as a part of Helsinki University
 * Software Engineering Lab in summer 2015
 */
package fi.iot.iiframework.source;

/**
 *
 * Configures a data source object based on database configuration information
 */
public class InformationSourceConfiguration {
    
    protected String id;
    protected String name;
    protected InformationSourceType type;
    protected String url;
    protected int readFrequency; //in seconds
    
}