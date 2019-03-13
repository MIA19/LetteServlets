package de.lette.validator;

import de.lette.models.RequestNumber;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("de.lette.RequestNumberValidator")
public class RequestNumberValidator implements Validator<RequestNumber> {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, RequestNumber requestNumber) throws ValidatorException {
        if(requestNumber.getYear() < 1900 || requestNumber.getYear() > 3000)
            throw new ValidatorException(
                    new FacesMessage("Year wrong"));
        else if(requestNumber.getSection().equals("00"))
            throw new ValidatorException(
                    new FacesMessage("Section wrong"));
        else if(requestNumber.getId() == 0)
            throw new ValidatorException(
                    new FacesMessage("Id wrong"));
    }
}
