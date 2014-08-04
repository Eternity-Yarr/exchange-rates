package org.lutra.rates;

import org.lutra.rates.adapters.DateAdapter;
import org.lutra.rates.adapters.ValuteMapAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.Map;

/**
 * 04.08.2014 at 13:01
 * CBRResponse of exchange-rates project
 *
 * @author Dmitry V. (savraz [at] gmail.com)
 */
@XmlRootElement(name = "ValCurs")
public class CBRResponse
{
	private Date date;
	private String name;
	private Map<String, ValuteNode> valute;

	@XmlAttribute(name ="Date")
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	@XmlAttribute(name ="name")
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	@XmlJavaTypeAdapter(ValuteMapAdapter.class)
	@XmlElement(name ="Valute")
	public Map<String, ValuteNode> getValute()
	{
		return valute;
	}
	public void setValute(Map<String, ValuteNode> valute)
	{
		this.valute = valute;
	}
}
