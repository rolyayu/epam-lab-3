package com.epam.xml;

import com.epam.components.ChocolateIngredient;
import com.epam.components.Ingredient;
import com.epam.components.Sweet;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class SweetXMLWriter {
    public void write(List<Sweet> sweets, String fileName) throws FileNotFoundException, XMLStreamException {
        XMLStreamWriter writer = null;
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        try {
            writer = factory.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("sweets");
            writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeAttribute("xsi:noNamespaceSchemaLocation", "sweets.xsd");
            for (Sweet sweet : sweets) {
                writer.writeStartElement("sweet");
                writer.writeAttribute("id", sweet.getIdentity());
                writer.writeStartElement("name");
                writer.writeCharacters(sweet.getName());
                writer.writeEndElement();
                writer.writeStartElement("production");
                writer.writeCharacters(sweet.getProduction());
                writer.writeEndElement();
                writer.writeStartElement("sweet-type");
                writer.writeCharacters(sweet.getSweetType().toString());
                writer.writeEndElement();
                writer.writeStartElement("energy");
                writer.writeCharacters(sweet.getEnergy().toString());
                writer.writeEndElement();
                writer.writeStartElement("ingredients");
                for (Ingredient ingredient : sweet.getIngredients()) {
                    writer.writeStartElement("ingredient");
                    writer.writeStartElement("ingredient-name");
                    writer.writeCharacters(ingredient.getName());
                    writer.writeEndElement();
                    writer.writeStartElement("weight");
                    writer.writeCharacters(ingredient.getWeight().toString());
                    writer.writeEndElement();
                    if (ingredient instanceof ChocolateIngredient chocoIngredient) {
                        writer.writeStartElement("chocolate-type");
                        writer.writeCharacters(chocoIngredient.getChocolateType());
                        writer.writeEndElement();
                    }
                    writer.writeEndElement();
                }
                writer.writeEndElement();
                writer.writeStartElement("nutritional-value");
                writer.writeStartElement("proteins");
                writer.writeCharacters(sweet.getNutritionalValue().getProteins().toString());
                writer.writeEndElement();
                writer.writeStartElement("fats");
                writer.writeCharacters(sweet.getNutritionalValue().getFats().toString());
                writer.writeEndElement();
                writer.writeStartElement("carbs");
                writer.writeCharacters(sweet.getNutritionalValue().getCarbs().toString());
                writer.writeEndElement();
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }
}