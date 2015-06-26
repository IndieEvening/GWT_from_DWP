package com.myGWTapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class MyGWTapp implements EntryPoint {

	@Override
	public void onModuleLoad() {
		MyViewModel.createView();
	}
}
