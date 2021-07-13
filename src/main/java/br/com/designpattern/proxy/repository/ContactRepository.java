package br.com.designpattern.proxy.repository;

import br.com.designpattern.proxy.model.Contact;

import java.util.List;

public interface ContactRepository {

    List<Contact> getAll();

}
