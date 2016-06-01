package com.nokia.unittests;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FirstJUnitFromMarcinTest {
	
       private List<String> values;
       private List<String> lista;
       
       @BeforeClass
       public static void setUpBeforeClass() {
              System.out.println("Prepare class");
       }
       
       @Before
       public void setUP() {
              System.out.println("Prepare");
              values = new ArrayList<String>();
              lista = new ArrayList<String>();
       }
       
       @Test
       public void shouldAddElements() {
    	   System.out.println("Run test: #1");
    	   // when
           values.add("element");
           Assert.assertThat(values.get(0), IsEqual.equalTo("element"));
       }
       
       @Test
       public void shouldRemoveElements() {
              System.out.println("Run test: #2");
              values.add("element");
              values.remove(0);
              Assert.assertEquals(values.size(),0);
       }
       
    	@Test
    	public void whatIsElementIndex() {
    		System.out.println("Run test: #3");
    		lista.add("pierwszy");
    		lista.add("drugi");
    		lista.add("trzeci");
    		Assert.assertThat(lista.get(1), IsEqual.equalTo("drugi"));
    		System.out.println("After the test of element indexes: " + lista.get(1));
    	} 

       @After
       public void finishTest() {
              System.out.println("After test");
       }
       
       @AfterClass
       public static void setUpAfterClass() {
              System.out.println("Finish class");
       }       

}
