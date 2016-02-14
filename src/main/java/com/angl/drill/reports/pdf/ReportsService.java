package com.angl.drill.reports.pdf;

import com.angl.drill.db.entity.ExcavationSession;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Random;

public class ReportsService {

    public static void generateBreedReport(String reportName) {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(reportName));

            document.open();

            Paragraph header = createHeader();

            Paragraph description = new Paragraph("Breed Report #36 " + new Date());

            PdfPTable table = createBreedTable();

            document.add(header);
            document.add(description);
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    public static void generateFaultsReport(String reportName) {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(reportName));

            document.open();

            Paragraph header = createHeader();

            PdfPTable faultsTable = createFaultsTable();

            Paragraph description = new Paragraph("Faults Report #17 " + new Date());

            document.add(header);
            document.add(description);
            document.add(faultsTable);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    public static void generateExcavationReport(String reportName, ExcavationSession session) {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(reportName));

            document.open();

            Paragraph header = createHeader();

            Paragraph description = new Paragraph("Excavation Report Session #43 " + new Date());

            PdfPTable table = createExcavationTable(session);

            document.add(header);
            document.add(description);
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    private static PdfPTable createExcavationTable(ExcavationSession session) {
        PdfPTable table = new PdfPTable(3);

        table.setSpacingBefore(25);

        table.setSpacingAfter(25);

        PdfPCell time = new PdfPCell(new Phrase("Time"));
        table.addCell(time);

        PdfPCell excavation = new PdfPCell(new Phrase("Excavation"));
        table.addCell(excavation);

        PdfPCell load = new PdfPCell(new Phrase("Load"));
        table.addCell(load);

        Random rand = new Random();
        double startTime = 1.00;
        int exc = 0;

        for (int i = 0; i < 50; i++) {
            table.addCell("" + startTime);
            table.addCell("" + exc);
            table.addCell("" + (i % 2 == 0 ? 160 : 180));

            startTime += 0.07;
            exc += rand.nextInt(15);
        }

        return table;
    }

    private static PdfPTable createFaultsTable() {
        PdfPTable table = new PdfPTable(4);

        table.setSpacingBefore(25);

        table.setSpacingAfter(25);

        PdfPCell time = new PdfPCell(new Phrase("Time"));
        table.addCell(time);

        PdfPCell excavation = new PdfPCell(new Phrase("Fault"));
        table.addCell(excavation);

        PdfPCell load = new PdfPCell(new Phrase("Priority"));
        table.addCell(load);

        PdfPCell session = new PdfPCell(new Phrase("Session ID"));
        table.addCell(session);

        Random rand = new Random();
        int exc = 0;

        for (int i = 0; i < 50; i++) {
            table.addCell("" + rand.nextInt(100));
            table.addCell("" + exc);
            table.addCell("" + (i % 2 == 0 ? 160 : 180));
            table.addCell("" + rand.nextInt(100));

            exc += rand.nextInt(15);
        }

        return table;
    }

    private static PdfPTable createBreedTable() {
        PdfPTable table = new PdfPTable(4);

        table.setSpacingBefore(25);

        table.setSpacingAfter(25);

        PdfPCell time = new PdfPCell(new Phrase("Time"));
        table.addCell(time);

        PdfPCell session = new PdfPCell(new Phrase("Session ID"));
        table.addCell(session);

        PdfPCell breedLength = new PdfPCell(new Phrase("Breed Length"));
        table.addCell(breedLength);

        Random rand = new Random();
        int exc = 0;

        for (int i = 0; i < 50; i++) {
            table.addCell("" + rand.nextInt(100));
            table.addCell("" + exc);
            table.addCell("" + rand.nextInt(200));

            exc += rand.nextInt(15);
        }

        return table;
    }


    private static Paragraph createHeader() throws DocumentException {
        Paragraph topHeader = new Paragraph("INAS DRILL",
                FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));

        return topHeader;
    }
}
