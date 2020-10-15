package ru.kpp.journalloader;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@SpringBootApplication
public class JournalloaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(JournalloaderApplication.class, args);
    }

    @Bean
    public CommandLineRunner loader(JournalRepository journalRepository) {
        return (args) -> {
            File source = new File("./in");

            Logger logger = Logger.getLogger(JournalloaderApplication.class.getName());
            FileHandler handler = new FileHandler("log.txt", true);
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);

            String[] files = source.list((sourceFile, name) -> name.endsWith(".xls"));

            if (files != null) {
                for (String file : files) {
                    try {
                        String filePath = source + "/" + file;
                        ArrayList<Journal> journalArray = new ArrayList<>();

                        HSSFWorkbook workBook = new HSSFWorkbook(new FileInputStream(new File(filePath)));
                        HSSFSheet sheet = workBook.getSheetAt(0);

                        for (int i = 16; i <= sheet.getLastRowNum(); i++) {
                            Journal journal = new Journal();
                            journal.setRequestDate(String.valueOf(sheet.getRow(i).getCell(0)));
                            journal.setRequestTime(String.valueOf(sheet.getRow(i).getCell(1)));
                            journal.setRequestDateTime(new Timestamp(new SimpleDateFormat("dd.MM.yyyy hh:mm")
                                    .parse(sheet.getRow(i).getCell(0) + " "
                                            + sheet.getRow(i).getCell(1)).getTime()));
                            journal.setSubject(String.valueOf(sheet.getRow(i).getCell(2)));
                            journal.setDepartment(String.valueOf(sheet.getRow(i).getCell(3)));
                            journal.setUserName(String.valueOf(sheet.getRow(i).getCell(4)));
                            journal.setGRZ(String.valueOf(sheet.getRow(i).getCell(5)));
                            journal.setVIN(String.valueOf(sheet.getRow(i).getCell(6)));
                            journal.setBack(String.valueOf(sheet.getRow(i).getCell(7)));
                            journal.setChassi(String.valueOf(sheet.getRow(i).getCell(8)));
                            journal.setPTC(String.valueOf(sheet.getRow(i).getCell(9)));
                            journal.setCTC(String.valueOf(sheet.getRow(i).getCell(10)));
                            journal.setAdmNum(String.valueOf(sheet.getRow(i).getCell(11)));
                            journal.setDocNum(String.valueOf(sheet.getRow(i).getCell(12)));
                            journal.setFamilyOrganization(String.valueOf(sheet.getRow(i).getCell(13)));
                            journal.setName(String.valueOf(sheet.getRow(i).getCell(14)));
                            journal.setFatherName(String.valueOf(sheet.getRow(i).getCell(15)));
                            journal.setBirthday(String.valueOf(sheet.getRow(i).getCell(16)));
                            journal.setSerialPas(String.valueOf(sheet.getRow(i).getCell(17)));
                            journal.setSerialVU(String.valueOf(sheet.getRow(i).getCell(18)));
                            journal.setINN(String.valueOf(sheet.getRow(i).getCell(19)));
                            journal.setOGRN(String.valueOf(sheet.getRow(i).getCell(20)));
                            journal.setLoadDate(new Timestamp(System.currentTimeMillis()));
                            if (!journalArray.contains(journal)) {
                                journalArray.add(journal);
                            }
                        }
                        journalRepository.saveAll(journalArray);
                        logger.log(Level.INFO, "Successful load file: " + file);

                        Files.move(Paths.get(filePath), Paths.get("./archive/" + file));
                        logger.log(Level.INFO, "File: " + file + " moved to ./archive");
                    } catch (Exception e) {
                        logger.log(Level.WARNING, file + ": " + e);
                    }
                }
            }
        };
    }
}
