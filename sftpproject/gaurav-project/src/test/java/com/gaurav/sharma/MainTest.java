package com.gaurav.sharma;

import junit.framework.TestCase;

public class MainTest extends TestCase{


	public void testmain(){
		Main main = new Main();
		assertEquals("gaurav",main.getName());
	}
}
