package br.com.designpattern.factorymethod.repository.impl;

import au.com.bytecode.opencsv.CSVReader;
import br.com.designpattern.factorymethod.contact.Contact;
import br.com.designpattern.factorymethod.repository.ContactRepository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ContactCsvRepository implements ContactRepository {

    private final String fileName;

    public ContactCsvRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Contact> getAll() {
        List<Contact> contacts = new ArrayList<>();
        CSVReader csvReader = null;

        try {
            URI uri = this.getClass().getResource("/" + fileName).toURI();
            File csvFile = new File(uri);
            FileReader fileReader = new FileReader(csvFile);
            csvReader = new CSVReader(fileReader);
            String [] nextLine;

            while ((nextLine = csvReader.readNext()) != null) {
                contacts.add(new Contact(nextLine[0].trim(), nextLine[1].trim()));
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while reading csv file", e);
        } finally {
            try {
                csvReader.close();
            } catch (IOException e) { }
        }

        return contacts;
    }

}
