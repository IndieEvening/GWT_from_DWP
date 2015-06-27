package com.myGWTapp.server;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *  {@link NazwaKlasy#nazwaMetody(argumenty)}
 */
@RemoteServiceRelativePath("addcustomer")
public interface AddCustomerService extends RemoteService {

	public String addCustomer(String name, String surname);
}
