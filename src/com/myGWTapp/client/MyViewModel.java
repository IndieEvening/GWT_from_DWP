package com.myGWTapp.client;

import java.awt.TextField;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.myGWTapp.server.AddCustomerService;
import com.myGWTapp.server.AddCustomerServiceAsync;

public class MyViewModel {

	public static void createView() {
		
		final AddCustomerServiceAsync asyncInterface = GWT.create(AddCustomerService.class);
		
		/*
		 * Data wypozyczenia - to mozna generowac automatycznie pobierajac czas z systemu
		 * Pole wyboru dla czasu wypozyczenia - od aktualnej daty zaczniemy odliczac zegar w dół
		 * Jakies zdjecia, dane wypozyczanych samochodów, dane ludzi
		 * CZyli jakeis fajne mapowanie mozna zrobic tabel w ORM
		 * 
		 */

		final TabPanel tabPanel = new TabPanel();
		tabPanel.setStyleName("contenttabpanel");
		tabPanel.setWidth("auto");

		RootPanel.get("personalContainer").add(tabPanel);

		final FlexTable tab1 = new FlexTable();
		tabPanel.add(tab1, "Dodaj klienta", false);
		
		final Label name = new Label();
		name.setWidth("100px");
		name.setText("Imie");
		tab1.setWidget(0, 0, name);
		
		final TextBox nameInput = new TextBox();
		nameInput.setWidth("300px");
		tab1.setWidget(0,  1, nameInput);
		
		final Label surname = new Label("Nazwisko");
		surname.setWidth("100px");
		tab1.setWidget(1, 0, surname);
		
		final TextBox surnameInput = new TextBox();
		surnameInput.setWidth("300px");
		tab1.setWidget(1, 1, surnameInput);

		final Button sendButton = new Button("Wyslij dane");
		sendButton.setWidth("200px");
		
		tab1.setWidget(2, 0, sendButton);
		
		sendButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent e) {
				
				asyncInterface.addCustomer(nameInput.getText(), surnameInput.getText(), new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String arg0) {
						// Signal Success
					}
					
					@Override
					public void onFailure(Throwable arg0) {
						// Signal Failure
					}
				});
			}
		});
	}
}
