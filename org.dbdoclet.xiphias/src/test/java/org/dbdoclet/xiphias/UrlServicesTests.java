package org.dbdoclet.xiphias;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UrlServicesTests {

    @Test
    public void testGetPath_1()
        throws Exception {

        String path = UrlServices.getPath("http://www.test.org/der/pfad/ist/das/ziel");
        assertEquals("/der/pfad/ist/das/ziel", path);
    }
    
    @Test
    public void testGetPath_2()
        throws Exception {
    
        String path = UrlServices.getPath("cocs://der/pfad/ist/das/ziel");
        assertEquals("der/pfad/ist/das/ziel", path);
    }
    
    @Test
    public void testGetPath_3()
        throws Exception {
    
        String path = UrlServices.getPath("cocs://der/pfad/ist/das/ziel?lang=DE");
        assertEquals("der/pfad/ist/das/ziel", path);
    }

    @Test
    public void testGetQuery_1() {

        String query = UrlServices.getQuery("cocs://der/pfad?language=DE");
        assertEquals("language=DE", query);
    }

    @Test
    public void testGetParameter_1() {
        
        String param = UrlServices.getParameter("cocs://der/pfad?language=DE", "language");
        assertEquals("DE", param);
    }

    @Test
    public void testGetParameter_2() {
        
        String param = UrlServices.getParameter("cocs://der/pfad?param=key&language=DE&", "language");
        assertEquals("DE", param);
    }

    @Test
    public void testGetParameter_3() {
        
        String param = UrlServices.getParameter("cocs://der/pfad?param=key&&language=DE&&param=&", "language");
        assertEquals("DE", param);
    }
}
