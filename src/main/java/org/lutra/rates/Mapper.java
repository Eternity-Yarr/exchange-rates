package org.lutra.rates;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * 04.08.2014 at 13:03
 * Mapper of exchange-rates project
 *
 * @author Dmitry V. (savraz [at] gmail.com)
 */
public class Mapper<T>
{
	Class<T> clazz;
	private JAXBContext context;

	public Mapper(Class<T> clazz) throws JAXBException
	{
		this.clazz = clazz;
		context = JAXBContext.newInstance(clazz);
	}

	public String asXML(T obj) throws JAXBException
	{
		if(obj != null && obj.getClass().equals(clazz))
		{
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			//Replacing default JAXB xml header to get rid of standalone="yes" property
			m.setProperty(Marshaller.JAXB_FRAGMENT, true);
			StringWriter xml = new StringWriter().append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");

			m.marshal(obj, xml);

			return xml.toString();
		}
		else
			throw new IllegalArgumentException(
				String.format(
					"Object supplied for marshalling of wrong type expected %s, given %s",
					clazz,
					obj != null ? obj.getClass() : "null"));
	}

	public T asPOJO(InputStream xml) throws JAXBException
	{
		Unmarshaller um = context.createUnmarshaller();
		Object o;
		try
		{
			o = um.unmarshal(xml);
		}
		catch(IllegalArgumentException e)
		{
			throw new JAXBException(e);
		}

		//noinspection unchecked
		@SuppressWarnings("Unchecked")
		T t = (T)o;

		return t;
	}
}
