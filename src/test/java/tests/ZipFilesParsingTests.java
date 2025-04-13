package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ZipFilesParsingTests {

    private final ClassLoader cl = ZipFilesParsingTests.class.getClassLoader();


    @Test
    void testPdfFileParsing() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                (Objects.requireNonNull(cl.getResourceAsStream("samples-non.zip")))
        )) {
            ZipEntry entry;

            boolean found = false;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".pdf")) {
                    PDF pdf = new PDF(zis);
                    found = true;
                    assertTrue(pdf.text.contains("Пример PDF формы"));
                }
            }
            assertTrue(found, "PDF файл не найден в архиве!");
        }
    }

    @Test
    void testXlsxFileParsing() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                (Objects.requireNonNull(cl.getResourceAsStream("samples-non.zip")))
        )) {
            ZipEntry entry;

            boolean found = false;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".xlsx")) {
                    XLS xls = new XLS(zis);
                    found = true;
                    assertEquals("March", xls.excel.getSheetAt(0).getRow(3).getCell(1).getStringCellValue());
                    assertEquals("October", xls.excel.getSheetAt(0).getRow(10).getCell(1).getStringCellValue());

                }
            }
            assertTrue(found, "Xlsx файл не найден в архиве!");
        }
    }

    @Test
    void testCsvFileParsing() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                (Objects.requireNonNull(cl.getResourceAsStream("samples-non.zip")))
        )) {
            ZipEntry entry;

            boolean found = false;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    found = true;
                        List<String[]> data = csvReader.readAll();
                        assertEquals(8, data.size());
                        assertArrayEquals(
                                new String[] {"name","phoneNumber","email","address","userAgent","hexcolor"},
                                data.get(0)
                        );

                    }
                }
            assertTrue(found, "Csv файл не найден в архиве!");
            }
        }
    }
