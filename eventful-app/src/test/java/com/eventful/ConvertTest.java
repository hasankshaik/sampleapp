package com.eventful;

import com.eventful.search.Convertor;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.xml.xpath.XPathExpressionException;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by hshaik on 21/03/2017.
 */
public class ConvertTest {
    String xmlSample="<search>\n" +
            "<total_items>69</total_items>\n" +
            "<page_size>10</page_size>\n" +
            "<page_count>7</page_count>\n" +
            "<page_number>1</page_number>\n" +
            "<page_items />\n" +
            "<first_item />\n" +
            "<last_item />\n" +
            "<search_time>0.639</search_time>\n" +
            "<events>\n" +
            "<event id=\"E0-001-099120810-7\">\n" +
            "<title>Mobile Unlimited</title>\n" +
            "<description>Buy Kosher Handsets Online at Best Price</description>\n" +
            "<start_time>2019-01-03 22:00:00</start_time>\n" +
            "<stop_time />\n" +
            "<url></url>" +
            "<city_name>London</city_name></event></events></search>";

    @Test
    public void shouldConvert() throws XPathExpressionException {
        assertTrue(Convertor.convert(xmlSample).size()==1 );
        assertTrue(Convertor.convert(xmlSample).get(0).getCity_name().equals("London") );
    }

    @Test(expected=XPathExpressionException.class)
    public void shouldThrowExp() throws XPathExpressionException {
        Convertor.convert("");
    }
}
