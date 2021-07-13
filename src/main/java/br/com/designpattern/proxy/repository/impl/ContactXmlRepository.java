package br.com.designpattern.proxy.repository.impl;

import br.com.designpattern.proxy.model.Contact;
import br.com.designpattern.proxy.repository.ContactRepository;
import br.com.designpattern.proxy.extractor.ContactXmlExtractor;

import java.util.List;

public class ContactXmlRepository extends ContactXmlExtractor implements ContactRepository {

    private final String fileName;

    public ContactXmlRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }

    @Override
    public List<Contact> getAll() {
        return super.getAll();
    }

}
