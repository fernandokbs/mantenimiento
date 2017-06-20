
package net.webservicex;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "countrySoap", targetNamespace = "http://www.webserviceX.NET")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CountrySoap {


    /**
     * Get country name by country code
     * 
     * @param countryCode
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetCountryByCountryCode", action = "http://www.webserviceX.NET/GetCountryByCountryCode")
    @WebResult(name = "GetCountryByCountryCodeResult", targetNamespace = "http://www.webserviceX.NET")
    @RequestWrapper(localName = "GetCountryByCountryCode", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetCountryByCountryCode")
    @ResponseWrapper(localName = "GetCountryByCountryCodeResponse", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetCountryByCountryCodeResponse")
    public String getCountryByCountryCode(
        @WebParam(name = "CountryCode", targetNamespace = "http://www.webserviceX.NET")
        String countryCode);

    /**
     * Get International Dialing Code by country name 
     * 
     * @param countryName
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetISD", action = "http://www.webserviceX.NET/GetISD")
    @WebResult(name = "GetISDResult", targetNamespace = "http://www.webserviceX.NET")
    @RequestWrapper(localName = "GetISD", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetISD")
    @ResponseWrapper(localName = "GetISDResponse", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetISDResponse")
    public String getISD(
        @WebParam(name = "CountryName", targetNamespace = "http://www.webserviceX.NET")
        String countryName);

    /**
     * Get all countries with ISO code
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetCountries", action = "http://www.webserviceX.NET/GetCountries")
    @WebResult(name = "GetCountriesResult", targetNamespace = "http://www.webserviceX.NET")
    @RequestWrapper(localName = "GetCountries", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetCountries")
    @ResponseWrapper(localName = "GetCountriesResponse", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetCountriesResponse")
    public String getCountries();

    /**
     * Get currency by currency name 
     * 
     * @param currencyName
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetCurrencyCodeByCurrencyName", action = "http://www.webserviceX.NET/GetCurrencyCodeByCurrencyName")
    @WebResult(name = "GetCurrencyCodeByCurrencyNameResult", targetNamespace = "http://www.webserviceX.NET")
    @RequestWrapper(localName = "GetCurrencyCodeByCurrencyName", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetCurrencyCodeByCurrencyName")
    @ResponseWrapper(localName = "GetCurrencyCodeByCurrencyNameResponse", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetCurrencyCodeByCurrencyNameResponse")
    public String getCurrencyCodeByCurrencyName(
        @WebParam(name = "CurrencyName", targetNamespace = "http://www.webserviceX.NET")
        String currencyName);

    /**
     * Get countries by country name 
     * 
     * @param countryName
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetISOCountryCodeByCountyName", action = "http://www.webserviceX.NET/GetISOCountryCodeByCountyName")
    @WebResult(name = "GetISOCountryCodeByCountyNameResult", targetNamespace = "http://www.webserviceX.NET")
    @RequestWrapper(localName = "GetISOCountryCodeByCountyName", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetISOCountryCodeByCountyName")
    @ResponseWrapper(localName = "GetISOCountryCodeByCountyNameResponse", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetISOCountryCodeByCountyNameResponse")
    public String getISOCountryCodeByCountyName(
        @WebParam(name = "CountryName", targetNamespace = "http://www.webserviceX.NET")
        String countryName);

    /**
     * Get all currencycode for each country 
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetCurrencyCode", action = "http://www.webserviceX.NET/GetCurrencyCode")
    @WebResult(name = "GetCurrencyCodeResult", targetNamespace = "http://www.webserviceX.NET")
    @RequestWrapper(localName = "GetCurrencyCode", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetCurrencyCode")
    @ResponseWrapper(localName = "GetCurrencyCodeResponse", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetCurrencyCodeResponse")
    public String getCurrencyCode();

    /**
     * Get country by currency code
     * 
     * @param currencyCode
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetCountryByCurrencyCode", action = "http://www.webserviceX.NET/GetCountryByCurrencyCode")
    @WebResult(name = "GetCountryByCurrencyCodeResult", targetNamespace = "http://www.webserviceX.NET")
    @RequestWrapper(localName = "GetCountryByCurrencyCode", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetCountryByCurrencyCode")
    @ResponseWrapper(localName = "GetCountryByCurrencyCodeResponse", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetCountryByCurrencyCodeResponse")
    public String getCountryByCurrencyCode(
        @WebParam(name = "CurrencyCode", targetNamespace = "http://www.webserviceX.NET")
        String currencyCode);

    /**
     * Get all currency,currency code for all countries 
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetCurrencies", action = "http://www.webserviceX.NET/GetCurrencies")
    @WebResult(name = "GetCurrenciesResult", targetNamespace = "http://www.webserviceX.NET")
    @RequestWrapper(localName = "GetCurrencies", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetCurrencies")
    @ResponseWrapper(localName = "GetCurrenciesResponse", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetCurrenciesResponse")
    public String getCurrencies();

    /**
     * Get currency by country name 
     * 
     * @param countryName
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetCurrencyByCountry", action = "http://www.webserviceX.NET/GetCurrencyByCountry")
    @WebResult(name = "GetCurrencyByCountryResult", targetNamespace = "http://www.webserviceX.NET")
    @RequestWrapper(localName = "GetCurrencyByCountry", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetCurrencyByCountry")
    @ResponseWrapper(localName = "GetCurrencyByCountryResponse", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetCurrencyByCountryResponse")
    public String getCurrencyByCountry(
        @WebParam(name = "CountryName", targetNamespace = "http://www.webserviceX.NET")
        String countryName);

    /**
     * Get greenwich mean time(GMT) by country name 
     * 
     * @param countryName
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetGMTbyCountry", action = "http://www.webserviceX.NET/GetGMTbyCountry")
    @WebResult(name = "GetGMTbyCountryResult", targetNamespace = "http://www.webserviceX.NET")
    @RequestWrapper(localName = "GetGMTbyCountry", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetGMTbyCountry")
    @ResponseWrapper(localName = "GetGMTbyCountryResponse", targetNamespace = "http://www.webserviceX.NET", className = "net.webservicex.GetGMTbyCountryResponse")
    public String getGMTbyCountry(
        @WebParam(name = "CountryName", targetNamespace = "http://www.webserviceX.NET")
        String countryName);

}