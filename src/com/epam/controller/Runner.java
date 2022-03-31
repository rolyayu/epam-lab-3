package com.epam.controller;

import com.epam.comparator.SweetNameComparator;
import com.epam.comparator.SweetWeightComparator;
import com.epam.components.Sweet;
import com.epam.xml.SweetXMLReader;
import com.epam.xml.SweetXMLValidator;
import com.epam.xml.SweetXMLWriter;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Runner {

    public static final String XML_FILE_NAME = "resource" + File.separator + "sweets.xml";
    public static final String XML_NEW_FILE_NAME = "resource" + File.separator + "sweetsNew.xml";

    private static List<Sweet> sweets = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        init();
        printSweetsConsole();
        sortSweets();
        printSweetsConsole();
        printSweetsXML();
    }

    private static void init() throws Exception {
        SweetXMLValidator validator = new SweetXMLValidator(XML_FILE_NAME);
        if (validator.validate()) {
            sweets = new SweetXMLReader().read(XML_FILE_NAME);
        }
    }

    private static void printSweetsConsole() {
        sweets.forEach(System.out::println);
    }

    private static void printSweetsXML() {
        SweetXMLWriter writer = new SweetXMLWriter();
        try {
            writer.write(sweets, XML_NEW_FILE_NAME);
            System.out.println("writing into " + XML_NEW_FILE_NAME + " completed");
        } catch (FileNotFoundException fileEx) {
            System.out.println("There is no " + XML_NEW_FILE_NAME + " file.");
        } catch (XMLStreamException xmlEx) {
            xmlEx.printStackTrace();
        }
    }

    private static void sortSweets() {
        Comparator<Sweet> comparator = new SweetWeightComparator().thenComparing(new SweetNameComparator());
        sweets.sort(comparator);
        System.out.println("sort completed");
    }
}
