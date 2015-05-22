/*
 * IoT - Industrial Internet Framework
 * Apache License Version 2.0, January 2004
 * Released as a part of Helsinki University
 * Software Engineering Lab in summer 2015
 */
package fi.iot.iiframework.views;

import org.junit.Test;
import static org.junit.Assert.*;

public class ViewParamsTest {

    @Test
    public void newViewParamsObjectIsCreatedSuccessfully() {
        ViewParams params = new ViewParams();
        assertNotEquals(null, params);
        ViewParams params2 = new ViewParams("title", "content");
        assertEquals("default", params2.getFootertype());
        assertEquals("default", params2.getHeadertype());
        assertEquals("title", params2.getPagetitle());
        assertEquals("content", params2.getContent());
    }
    
    @Test
    public void canSetAllTypesProperly() {
        ViewParams params = new ViewParams();
        params.setAllTypes("test");
        assertEquals("test", params.getFootertype());
        assertEquals("test", params.getHeadertype());
    }
}