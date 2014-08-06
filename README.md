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

Сборка jar осуществляется [maven](http://maven.apache.org/)'ом
* ```$ git clone https://github.com/Eternity-Yarr/exchange-rates.git```
* ```$ cd exchange-rates```
* ```$ mvn package```

Должно получиться что-то вроде:
```
[...cut...]
[INFO] 
[INFO] --- maven-jar-plugin:2.2:jar (default-jar) @ exchange-rates ---
[INFO] Building jar: /home/user/dist/exchange-rates/target/exchange-rates-1.1.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.378s
[INFO] Finished at: Mon Aug 04 15:04:30 MSK 2014
[INFO] Final Memory: 14M/88M
[INFO] ------------------------------------------------------------------------
```
