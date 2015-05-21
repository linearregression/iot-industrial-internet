package fi.iot.iiframework.xmltodataobject;

import fi.iot.iiframework.dataobject.DataObject;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XmlToObject {

    /**
     * Converts XML representation of DataObject to actual object.
     *
     * @param url URL to load the XML from
     * @return DataObject based on the XML
     */
    public static DataObject convertXml(String url) throws JAXBException, MalformedURLException {
        DataObject data = null;

        JAXBContext context = JAXBContext.newInstance(DataObject.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        data = (DataObject) unmarshaller.unmarshal(new URL(url));

        return data;
    }
}
