package org.lutra.rates;

import org.junit.Test;

import javax.xml.bind.JAXBException;

import java.io.InputStream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Unit test for simple App.
 */
public class RatesTest
{
	@Test
	public void testMarshall()
	{
		try
		{
			Mapper<CBRResponse> m = new Mapper<CBRResponse>(CBRResponse.class);
			InputStream is = RatesTest.class.getResourceAsStream("example.xml");
			assertNotNull(is);
			CBRResponse response = m.asPOJO(is);
			System.out.println(response);
		}
		catch(JAXBException e)
		{
			e.printStackTrace();
			fail("Failed during marshalling");
		}
	}
}
