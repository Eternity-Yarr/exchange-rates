exchange-rates
==============

CBR rates for RUB

Курсы к рублю с [сайта](http://www.cbr.ru/scripts/XML_daily.asp) центробанка.

Использование:
```
Rates r = Rates.i();
double usd = r.getRateOf("USD"); // 35.7272
double eur = r.getRateOf("EUR"); // 47.1232
```
