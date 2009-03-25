package org.mobicents.ipbx.session.call.framework;

import javax.servlet.sip.SipSession;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Startup;
import org.mobicents.mscontrol.MsConnection;
import org.mobicents.mscontrol.MsEndpoint;
import org.mobicents.mscontrol.MsLink;

/**
 *  Each Sip Session will have exactly one instance of this class.
 *
 */

@Name("mediaSessionStore")
@Startup
@Scope(ScopeType.SESSION)
public class MediaSessionStore {
	private MsConnection msConnection;
	private MsLink msLink;
	private MsEndpoint msEndpoint;
	@In(required=false) SipSession sipSession;
	
	@Create
	public void create() {
		IVRHelperManager.instance().put(sipSession, this);
	}
	
	@Destroy
	public void destroy() {
		IVRHelperManager.instance().remove(sipSession);
	}
	
	public MsConnection getMsConnection() {
		return msConnection;
	}
	public MsLink getMsLink() {
		return msLink;
	}
	public void setMsConnection(MsConnection msConnection) {
		this.msConnection = msConnection;
	}
	public void setMsLink(MsLink msLink) {
		this.msLink = msLink;
	}
	public MsEndpoint getMsEndpoint() {
		return msEndpoint;
	}
	public void setMsEndpoint(MsEndpoint msEndpoint) {
		this.msEndpoint = msEndpoint;
	}
	

}
