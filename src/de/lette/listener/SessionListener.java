package de.lette.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author invalid
 * Atm only for debug purposes
 */
@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("Attribute added : " + event.getName() + " : " + event.getValue());		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("Attribute removed : " + event.getName() + " : " + event.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("Attribute replaced : " + event.getName() + " : " + event.getValue());			
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	}

}
