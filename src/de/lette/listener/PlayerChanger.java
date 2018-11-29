package de.lette.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class PlayerChanger implements ServletRequestListener {

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
    	var request = sre.getServletRequest();
    	if(request.getParameterNames().hasMoreElements()) {
    		var session = ((HttpServletRequest) request).getSession();
    		var player = (char) session.getAttribute("player");
    		player = player == 'O' ? 'X' : 'O';
    		session.setAttribute("player", player);
    	}
    }
	
}
