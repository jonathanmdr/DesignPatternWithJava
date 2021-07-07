package br.com.designpattern.factorymethod.repository;

import br.com.designpattern.factorymethod.contact.Contact;

import java.util.List;

public interface ContactRepository {

    List<Contact> getAll();

}
