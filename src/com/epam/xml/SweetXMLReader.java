package com.epam.xml;

import com.epam.components.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class SweetXMLReader {
    public List<Sweet> read(String fileName) throws FileNotFoundException {
        XMLStreamReader reader = null;
        try {
            List<Sweet> sweets = new ArrayList<>();
            Sweet sweet = null;
            List<Ingredient> ingredients = new ArrayList<>();
            Ingredient ingredient = null;
            NutritionalValue value = new NutritionalValue();
            XMLInputFactory factory = XMLInputFactory.newFactory();
            reader = factory.createXMLStreamReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("sweet".equals(tagName)) {
                            sweet = new Sweet();
                            sweet.setIdentity(reader.getAttributeValue(null, "id"));
                        } else if ("name".equals(tagName)) {
                            sweet.setName(reader.getElementText());
                        } else if ("production".equals(tagName)) {
                            sweet.setProduction(reader.getElementText());
                        } else if ("sweet-type".equals(tagName)) {
                            sweet.setSweetType(SweetType.valueOf(reader.getElementText()));
                        } else if ("energy".equals(tagName)) {
                            sweet.setEnergy(Integer.parseInt(reader.getElementText()));
                        } else if ("ingredients".equals(tagName)) {
                            ingredients = new ArrayList<>();
                        } else if ("ingredient".equals(tagName)) {
                            ingredient = new Ingredient();
                        } else if ("ingredient-name".equals(tagName)) {
                            ingredient.setName(reader.getElementText());
                        } else if ("weight".equals(tagName)) {
                            ingredient.setWeight(Integer.parseInt(reader.getElementText()));
                        } else if ("chocolate-type".equals(tagName)) {
                            ingredient = new ChocolateIngredient(ingredient, reader.getElementText());
                        } else if ("proteins".equals(tagName)) {
                            value.setProteins(Integer.parseInt(reader.getElementText()));
                        } else if ("fats".equals(tagName)) {
                            value.setFats(Integer.parseInt(reader.getElementText()));
                        } else if ("carbs".equals(tagName)) {
                            value.setCarbs(Integer.parseInt(reader.getElementText()));
                            sweet.setNutritionalValue(value);
                        }
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("sweet".equals(tagName)) {
                            sweets.add(sweet);
                        } else if ("ingredient".equals(tagName)) {
                            ingredients.add(ingredient);
                        } else if ("ingredients".equals(tagName)) {
                            sweet.setIngredients(ingredients);
                        }
                        break;
                    }
                }
            }
            return sweets;
        } catch (XMLStreamException e) {
            return null;
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
            }
        }
    }
}
