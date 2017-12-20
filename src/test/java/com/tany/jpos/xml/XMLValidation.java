package com.tany.jpos.xml;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * @Author ThinkPad
 * @Since 1.0
 */
public class XMLValidation {

    public static void main(String[] args) throws Exception {
        System.out.println(validateXMLSchema("","E:/other/ccpt/tany-jpos/out/production/resources/com/tany/jpos/xml/ISO8583.xml"));;
    }
    public static boolean validateXMLSchema(String xsdPath, String xmlPath){

        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("/E:/other/ccpt/tany-jpos/out/production/resources/com/tany/jpos/xml/ISO8583.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            e.printStackTrace();
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }
}
