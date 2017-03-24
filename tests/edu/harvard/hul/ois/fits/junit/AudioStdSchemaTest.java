/* 
 * Copyright 2009 Harvard University Library
 * 
 * This file is part of FITS (File Information Tool Set).
 * 
 * FITS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * FITS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with FITS.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.harvard.hul.ois.fits.junit;

import java.io.File;
import java.util.Scanner;

import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.harvard.hul.ois.fits.Fits;
import edu.harvard.hul.ois.fits.FitsOutput;
import edu.harvard.hul.ois.fits.tests.AbstractXmlUnitTest;

public class AudioStdSchemaTest extends AbstractXmlUnitTest {

	/*
	 *  Only one Fits instance is needed to run all tests.
	 *  This also speeds up the tests.
	 */
	private static Fits fits;

	@BeforeClass
	public static void beforeClass() throws Exception {
		// Set up FITS for entire class.
		fits = new Fits();
	}
	
	@AfterClass
	public static void afterClass() {
		fits = null;
	}
    
    @Test  
	public void testAudioChunk() throws Exception {   

		String inputFilename = "testchunk.wav";
    	File input = new File("testfiles/" + inputFilename);
    	FitsOutput fitsOut = fits.examine(input);
    	fitsOut.saveToDisk("test-generated-output/testchunk_wav_Output.xml");
    	
		XMLOutputter serializer = new XMLOutputter(Format.getPrettyFormat());
		String actualXmlStr = serializer.outputString(fitsOut.getFitsXml());

		// Read in the expected XML file
		Scanner scan = new Scanner(new File(
				"testfiles/output/testchunk.wav.xml"));
		String expectedXmlStr = scan.
				useDelimiter("\\Z").next();
		scan.close();

		testActualAgainstExpected(actualXmlStr, expectedXmlStr, inputFilename);
	}

}

