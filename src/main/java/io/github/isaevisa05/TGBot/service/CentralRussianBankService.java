package io.github.isaevisa05.TGBot.service;

import io.github.isaevisa05.TGBot.dto.GetCursOnDateXml;
import io.github.isaevisa05.TGBot.dto.GetCursOnDateXmlResponse;
import io.github.isaevisa05.TGBot.dto.ValuteCursOnDate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class CentralRussianBankService extends WebServiceTemplate {

    @Value("${cbr.api.url}")
    private String cbrApiUrl;

    public List<ValuteCursOnDate> getCurrenciesFromCbr() throws DatatypeConfigurationException {
        final GetCursOnDateXml getCursOnDateXml = new GetCursOnDateXml();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());

        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        getCursOnDateXml.setOnDate(xmlGregorianCalendar);

        System.out.println(getCursOnDateXml);

        GetCursOnDateXmlResponse response = (GetCursOnDateXmlResponse) marshalSendAndReceive(cbrApiUrl, getCursOnDateXml);

        if(response == null) {
            throw new IllegalArgumentException("Не удалось получить данные от ЦБ РФ");
        }

        final List<ValuteCursOnDate> courses = response.getGetCursOnDateXmlResult().getValuteData();
        courses.forEach(course -> course.setName(course.getName().trim()));
        return courses;
    }

    public ValuteCursOnDate getCourseForCurrency(String code) throws DatatypeConfigurationException {
        return getCurrenciesFromCbr().stream().filter(currency -> code.equals(currency.getChCode())).findFirst().get();
    }
}
