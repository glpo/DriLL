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
        PdfPTable table = new PdfPTable(6);

        table.setSpacingBefore(25);
        table.setSpacingAfter(25);

        PdfPCell n = new PdfPCell(new Phrase("#"));
        table.addCell(n);

        PdfPCell time = new PdfPCell(new Phrase("Burova Ustanovka"));
        table.addCell(time);

        PdfPCell breedTypeAndLoad = new PdfPCell(new Phrase("Tip porodi/Navantazxhennya na doloto, kH"));
        table.addCell(breedTypeAndLoad);

        PdfPCell excavation = new PdfPCell(new Phrase("Prohodka"));
        table.addCell(excavation);

        PdfPCell speed = new PdfPCell(new Phrase("Shvidkist znoshennya ozbroennya dolota"));
        table.addCell(speed);

        PdfPCell avgCost = new PdfPCell(new Phrase("Seredne znachennya vartosti 1m prohodki za dobu"));
        table.addCell(avgCost);

        Random rand = new Random();
        int exc = 1;

        for (int i = 0; i < 50; i++) {
            table.addCell("" + (i + 1));
            table.addCell("Burova IFKR #23");
            if(i < 15) {
                table.addCell("Poroda#1/" + (800 + rand.nextInt(700)));
            } else if(i >= 15 && i <= 35) {
                table.addCell("Poroda#2/" + (600 + rand.nextInt(500)));
            } else if(i > 35) {
                table.addCell("Poroda#3/" + (400 + rand.nextInt(600)));
            }
            table.addCell("" + exc);
            table.addCell("" + String.format("%.2f", 0 + (1 - 0) * rand.nextDouble()));
            table.addCell("" + rand.nextInt(12 - 8 + 1) + 8);

            exc += rand.nextInt(15);
        }

        return table;
    }

    private static PdfPTable createFaultsTable() {
        PdfPTable table = new PdfPTable(6);

        table.setSpacingBefore(25);
        table.setSpacingAfter(25);

        PdfPCell n = new PdfPCell(new Phrase("#"));
        table.addCell(n);

        PdfPCell time = new PdfPCell(new Phrase("Burova Ustanovka"));
        table.addCell(time);

        PdfPCell breedTypeAndLoad = new PdfPCell(new Phrase("Tip porodi"));
        table.addCell(breedTypeAndLoad);

        PdfPCell load = new PdfPCell(new Phrase("Navantazhennay na doloto"));
        table.addCell(load);

        PdfPCell excavation = new PdfPCell(new Phrase("Prohodka"));
        table.addCell(excavation);

        PdfPCell massage = new PdfPCell(new Phrase("Vikluchna situatsiya"));
        table.addCell(massage);

        Random rand = new Random();
        int exc = 220;

        for (int i = 0; i < 50; i++) {
            table.addCell("" + (i + 1));
            table.addCell("Burova IFKR #23");
            if(i < 15) {
                table.addCell("Poroda#1");
            } else if(i >= 15 && i <= 35) {
                table.addCell("Poroda#2");
            } else if(i > 35) {
                table.addCell("Poroda#3");
            }
            table.addCell("" + (800 + rand.nextInt(500)));
            table.addCell("" + exc);
            if(i % 2 == 0) {
                table.addCell("Raise the chisel!");
            } else if(i % 3 == 0) {
                table.addCell("Breed changed!");
            } else if(i % 5 == 0) {
                table.addCell("Drilling is too fast.");
            } else {
                table.addCell("System error");
            }

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
