package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZipParsingFilesTests {

    private final ClassLoader classLoader = ZipParsingFilesTests.class.getClassLoader();

    @Test
    void zipFileParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                Objects.requireNonNull(classLoader.getResourceAsStream("samples.zip"))
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                System.out.println(entry.getName());
            }
        }
    }

    @Test
    void pdfFileParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                Objects.requireNonNull(classLoader.getResourceAsStream("samples.zip"))
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".pdf")) {
                    PDF pdf = new PDF(zis);
                    assertTrue(pdf.text.contains("Пример PDF формы"));
                }
            }
        }
    }

    @Test
    void xlsxFileParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                Objects.requireNonNull(classLoader.getResourceAsStream("samples.zip"))
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".xlsx")) {
                    XLS xls = new XLS(zis);
                    Assertions.assertEquals("March", xls.excel.getSheetAt(0).getRow(3).getCell(1).getStringCellValue());
                    Assertions.assertEquals("October", xls.excel.getSheetAt(0).getRow(10).getCell(1).getStringCellValue());
                }
            }
        }
    }

    @Test
    void csvFileParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                Objects.requireNonNull(classLoader.getResourceAsStream("samples.zip"))
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));

                        List<String[]> data = csvReader.readAll();
                        Assertions.assertEquals(8, data.size());
                        Assertions.assertArrayEquals(
                                new String[] {"name","phoneNumber","email","address","userAgent","hexcolor"},
                                data.get(0)
                        );
                    }
                }
            }
        }
    }
