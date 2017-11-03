/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundoexcel;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matinal
 */
public class LibroTest {
    
    public LibroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNombreArchivo method, of class Libro.
     */
    @Test
    public void testGetNombreArchivo() {
        System.out.println("getNombreArchivo");
        Libro instance = new Libro();
        String expResult = "nuevo.xlsx";
        String result = instance.getNombreArchivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreArchivo method, of class Libro.
     */
    @Test
    public void testSetNombreArchivo() {
        System.out.println("setNombreArchivo");
        String nombreArchivo = "";
        Libro instance = new Libro();
        instance.setNombreArchivo(nombreArchivo);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addHoja method, of class Libro.
     */
    @Test
    public void testAddHoja() {
        System.out.println("addHoja");
     
        int filas = 20, columnas = 30;
        
        Hoja hoja = new Hoja("pepe", filas, columnas);
       
        for(int i=0; i < filas; i++){
            for(int j=0; j < columnas;j++){
                hoja.setDato((char)('A' + j) + " " +(i+1),i,j);
            }
        }
        
        Libro instance = new Libro();
        instance.addHoja(hoja);
        
        try {
            assertEquals(instance.indexHoja(0).compare(hoja), true);
        } catch (ExcelAPIException ex) {
            Logger.getLogger(LibroTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("The test case is a prototype.");
        }
          
    }

    /**
     * Test of removeHoja method, of class Libro.
     */
    @Test
    public void testRemoveHoja() throws Exception {
        System.out.println("removeHoja");
        int index = 0;
        Libro instance = new Libro("NuevoManolo.xlsx");
        Hoja expResult = new Hoja("Hoja 1", 5, 5);
        
       for(int i=0; i < expResult.getNFilas(); i++){
            for(int j=0; j < expResult.getNColumnas(); i++){
                expResult.setDato((char)('A'+j)+ " " +(i+1), i, j);
            }
        }
        instance.addHoja(expResult);
        
        Hoja result = instance.removeHoja(index);
        
        assertEquals("Error en removeHoja(): ",result.compare(expResult), true);
        
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /*
     * Test of indexHoja method, of class Libro.
     * Ya est ahecho en el testAddHoja
     */
    
    /*@Test
    public void testIndexHoja() throws Exception {
        System.out.println("indexHoja");
        int index = 0;
        Libro instance = new Libro();
        Hoja expResult = null;
        Hoja result = instance.indexHoja(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of load method, of class Libro.
     */
    
    //Hacerla nosotros
    @Test
    public void testLoad() {
        System.out.println("load");
        Libro instance = new Libro();
        instance.load();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class Libro.
     */
    @Test
    public void testSave_0args() throws Exception {
        System.out.println("Save");
        
        
        Libro libro = new Libro("testSave.xlsx");
        
        Hoja hoja1 = new Hoja("Mi hoja 1", 5,5);
        Hoja hoja2 = new Hoja("Mi hoja 2", 6,6);
        
        for(int i=0; i < 5; i++){
            for(int j=0; j < 5; j++){
                hoja1.setDato("Hoja 1:" +i+ ","+j, i, j);
            }
        }
        
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                hoja2.setDato("Hoja 2: " +i+ ","+j , i, j);
            }
        }
        
        //System.out.println("Escribiendo ....");
        libro.addHoja(hoja1);
        libro.addHoja(hoja2);
        libro.save();
        
        /*
        System.out.println("Leyendo entrada...");
        
        Libro libro2 = new Libro(nombreArchivo);
        libro2.load();
        assertEquals("guardar y cargar archivo comparar ", true, libro.compare(libro2));
        */

        
    }

    /**
     * Test of save method, of class Libro.
     */
    @Test
    public void testSave_String() throws Exception {
        System.out.println("save");
        String filename = "Manolo.xlsx";
        Libro instance = new Libro();
        instance.save(filename);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
