package com.myGWTapp.server;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AddCustomerServiceAsync {
	public void addCustomer(String name, String surname, AsyncCallback<String> callback);
}
