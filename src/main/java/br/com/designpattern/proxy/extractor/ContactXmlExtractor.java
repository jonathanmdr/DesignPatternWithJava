package br.com.designpattern.proxy.extractor;

import br.com.designpattern.proxy.model.Contact;
import com.thoughtworks.xstream.XStream;

import java.net.URL;
import java.util.List;

public abstract class ContactXmlExtractor {

    public abstract String getFileName();

    public List<Contact> getAll() {
        XStream xstream = new XStream();
        xstream.alias("contacts", List.class);
        xstream.alias("contact", Contact.class);

        URL file = this.getClass().getResource("/" + getFileName());
        return (List<Contact>) xstream.fromXML(file);
    }

}
