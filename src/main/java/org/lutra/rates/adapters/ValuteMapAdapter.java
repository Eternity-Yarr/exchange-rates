package org.lutra.rates.adapters;

import org.lutra.rates.ValuteNode;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.HashMap;
import java.util.Map;

/**
 * 04.08.2014 at 13:41
 * ValuteMapAdapter of exchange-rates project
 *
 * @author Dmitry V. (savraz [at] gmail.com)
 */
public class ValuteMapAdapter extends XmlAdapter<ValuteNode[], Map<String, ValuteNode>>
{
	@Override
	public Map<String, ValuteNode> unmarshal(ValuteNode[] xs) throws Exception
	{
		HashMap<String, ValuteNode> ret = new HashMap<String, ValuteNode>();
		for(ValuteNode x: xs)
			ret.put(x.getCharCode(), x);

		return ret;
	}
	@Override
	public ValuteNode[] marshal(Map<String, ValuteNode> v) throws Exception
	{
		return v.values().toArray(new ValuteNode[v.values().size()]);
	}
}
