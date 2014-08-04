package org.lutra.rates;

import org.junit.Test;

import javax.xml.bind.JAXBException;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class RatesTest
{
	@Test
	public void testMarshall()
	{
		try
		{
			Mapper<CBRResponse> m = new Mapper<>(CBRResponse.class);
			InputStream is = RatesTest.class.getResourceAsStream("example.xml");
			assertNotNull("No test data found", is);

			CBRResponse response = m.asPOJO(is);
			ValuteNode usd = response.getValute("USD");
			assertNotNull("USD shouldn't be null", usd);

			Calendar c = Calendar.getInstance();
			c.clear();
			c.set(2014, Calendar.AUGUST, 2);
			Date testDate = c.getTime();
			assertEquals("RUB/USD rate should equal 35.7272", 35.7272, usd.getValue().doubleValue(), 0.0001);
			assertEquals("Date should be 2014.8.2", testDate,response.getDate());
		}
		catch(JAXBException e)
		{
			e.printStackTrace();
			fail("Failed during marshalling");
		}
	}

	@Test
	public void testConnection()
	{
		Rates r = Rates.i();
		double usd = r.getRateOf("USD");
		double eur = r.getRateOf("EUR");
		ValuteNode vn = r.getValute("GBP");

		assertTrue("Non zero", usd > 0);
		assertTrue("Non zero", eur > 0);
		assertNotNull("GBP is still exists", vn);
		assertEquals("Name of GBP", "Фунт стерлингов Соединенного королевства", vn.getName());
	}
}
