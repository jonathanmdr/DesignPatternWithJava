package br.com.designpattern.decorator.repository;

import br.com.designpattern.decorator.model.Contact;

import java.io.IOException;

public interface ContactRepository {

    void insert(Contact contact);
    Contact findById(int id);

}
