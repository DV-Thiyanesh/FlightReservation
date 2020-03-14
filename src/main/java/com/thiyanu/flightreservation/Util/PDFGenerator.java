package com.thiyanu.flightreservation.Util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.thiyanu.flightreservation.entities.Reservation;

@Component
public class PDFGenerator {
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);

public void generateIternary(Reservation reservation, String filepath) {
	
	
    LOGGER.info("Inside generateIternary()");

	Document document = new Document();
	
	try {
		PdfWriter.getInstance(document, new FileOutputStream(filepath));
		document.open();
		document.add(generateTable(reservation));
		
		document.close();
		
	} catch (FileNotFoundException | DocumentException e) {
        LOGGER.info("Exception inside generateIternary()"+e);


	}
	

	
	
}

private PdfPTable generateTable(Reservation reservation) {

	PdfPTable table = new PdfPTable(2);
	
	PdfPCell cell;
	
	cell= new PdfPCell(new Phrase("Flight Iternary"));
    cell.setColspan(2);
    table.addCell(cell);
   
	cell= new PdfPCell(new Phrase("Flight Details"));
    cell.setColspan(2);
    table.addCell(cell);
    
    table.addCell("Airlines");
	table.addCell(reservation.getFlight().getOperatingairlines());
    
	table.addCell("Departure City");
	table.addCell(reservation.getFlight().getDeparturecity());
	
	table.addCell("Arrival City");
	table.addCell(reservation.getFlight().getArrivalcity());
	
	table.addCell("Flight Number");
	table.addCell(reservation.getFlight().getFlightnumber());
	
	table.addCell("Departure Date");
	table.addCell(reservation.getFlight().getDateeofdeparture().toString());
	
	table.addCell("Departure Time");
	table.addCell(reservation.getFlight().getEstimateddeparturetime().toString());
	
	cell= new PdfPCell(new Phrase("Passenger Details"));
    cell.setColspan(2);
    table.addCell(cell);
	
    table.addCell("First Name");
	table.addCell(reservation.getPassenger().getFirstname());
	
	 table.addCell("Last Name");
	 table.addCell(reservation.getPassenger().getLastname());
	
	 table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());
		
		 table.addCell("Phone");
			table.addCell(reservation.getPassenger().getPhone());
    
	return table;
}

}
