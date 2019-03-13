package de.lette.converter;

import de.lette.models.RequestNumber;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("de.lette.RequestNumberConverter")
public class RequestNumberConverter implements Converter<RequestNumber> {

    @Override
    public RequestNumber getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) throws ConverterException {
        String[] splitArr =  s.split("\\.");

        RequestNumber requestNumber = new RequestNumber();
        requestNumber.setYear(splitArr.length < 1 ? 0 : Integer.parseInt(splitArr[0]));
        requestNumber.setSection(splitArr.length < 2 ? "00" : splitArr[1]);
        requestNumber.setId(splitArr.length < 3 ? 0 : Long.parseLong(splitArr[2]));
        return requestNumber;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, RequestNumber requestNumber) throws ConverterException {
        return requestNumber == null ? "" : requestNumber.toString();
    }
}
