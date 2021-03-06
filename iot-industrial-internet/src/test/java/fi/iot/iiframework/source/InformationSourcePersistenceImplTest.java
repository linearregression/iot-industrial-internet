/*
 * IoT - Industrial Internet Framework
 * Apache License Version 2.0, January 2004
 * Released as a part of Helsinki University
 * Software Engineering Lab in summer 2015
 */
package fi.iot.iiframework.source;

import fi.iot.iiframework.domain.InformationSource;
import fi.iot.iiframework.services.domain.InformationSourceObjectProvider;
import fi.iot.iiframework.services.domain.InformationSourceService;
import fi.iot.iiframework.services.domain.ReadoutService;
import fi.iot.iiframework.services.domain.SensorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class InformationSourcePersistenceImplTest {

    InformationSourcePersistence persistence;

    @Mock
    InformationSourceService mockSourceService;

    @Mock
    SensorService mockSensorService;

    @Mock
    ReadoutService mockReadoutService;

    InformationSource mockSource;

    @Before
    public void setUp() {
        initMocks(this);
        persistence = new InformationSourcePersistenceImpl(
                mockSourceService,
                mockSensorService,
                mockReadoutService);

        mockSource = new InformationSource();
        InformationSourceObjectProvider.provideSensorsWithChildren(mockSource);
    }

    @Test
    public void sourcesAreSavedOnAddingSource() {
        persistence.addSource(mockSource);
        verify(mockSourceService).save(mockSource);
    }

    @Test
    public void sourcesAreUpdatedOnUpdatingSource() {
        persistence.updateSource(mockSource);
        verify(mockSourceService).save(mockSource);
    }

    @Test
    public void sourcesAreDeletedOnDeletingSource() {
        persistence.deleteSource(mockSource);
        verify(mockSourceService).delete(mockSource);
    }

}
