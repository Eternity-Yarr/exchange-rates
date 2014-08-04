exchange-rates
==============

### CBR rates for RUB

Курсы к рублю с [сайта](http://www.cbr.ru/scripts/XML_daily.asp) центробанка.

### Использование:
```
Rates r = Rates.i();
double usd = r.getRateOf("USD"); // 35.7272
double eur = r.getRateOf("EUR"); // 47.1232
ValuteNode gbp = r.getValute("GBP");
String name = gbp.getName(); // Фунт стерлингов Соединенного королевства
int code = gbp.getNumCode(); // 826
```

### Сборка:

Сборка осуществляется [maven](http://maven.apache.org/)'ом
* ```$ git clone https://github.com/Eternity-Yarr/exchange-rates.git```
* ```$ cd exchange-rates```
* ```$ mvn package```
