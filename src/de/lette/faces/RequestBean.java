package de.lette.faces;

import de.lette.models.Request;
import de.lette.models.RequestNumber;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SessionScoped
@Named("requestBean")
public class RequestBean implements Serializable {

    private RequestNumber requestNumber;
    private String desc;
    private Date date;

    private List<Request> requestList;

    public RequestBean()
    {
        this.requestList = new ArrayList<>();
    }

    public RequestNumber getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(RequestNumber requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }

    public void submit()
    {
        Request request = new Request();
        request.setRequestNumber(requestNumber);
        request.setDate(date);
        request.setDescription(desc);
        this.requestList.add(request);
    }
}
