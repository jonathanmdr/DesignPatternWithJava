package br.com.designpattern.proxy.repository.impl;

import br.com.designpattern.proxy.model.Contact;
import br.com.designpattern.proxy.repository.ContactRepository;
import br.com.designpattern.proxy.extractor.ContactXmlExtractor;

import java.util.List;
import java.util.stream.Collectors;

public class ContactBlackListFilter extends ContactXmlExtractor implements ContactRepository {

    private final String blackListFileName;
    private final ContactXmlRepository contactXmlRepository;

    public ContactBlackListFilter(String blackListFileName, ContactXmlRepository contactXmlRepository) {
        this.blackListFileName = blackListFileName;
        this.contactXmlRepository = contactXmlRepository;
    }

    @Override
    public String getFileName() {
        return this.blackListFileName;
    }

    @Override
    public List<Contact> getAll() {
        List<Contact> allContactsToSendEmail = contactXmlRepository.getAll();
        List<Contact> blackListContacts = super.getAll();
        return allContactsToSendEmail.stream()
                .filter(contact -> !blackListContacts.contains(contact))
                .collect(Collectors.toList());
    }

}
