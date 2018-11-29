package de.lette.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionInitializer implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  {
    	char[] field = {' ',' ',' ',' ',' ',' ',' ',' ',' '};
    	var player = 'O';
    	se.getSession().setAttribute("field", field);
    	se.getSession().setAttribute("player", player);
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    }
	
}
