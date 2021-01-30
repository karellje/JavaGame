package com.company;

import java.io.*;

/**
 *  En utility-klass där alla metoder för att behandla filer finns samlade
 *
 */
public class FileUtils {




    /** saveObject serialiserar ett objekt och sparar i en fil.
     *
     * @param objectToSave
     * @param fileName
     */
    public static void saveObject(Object objectToSave, String fileName) {

        try {
            FileOutputStream outStream = new FileOutputStream(fileName);
            ObjectOutputStream obj = new ObjectOutputStream(outStream);

            obj.writeObject(objectToSave);


            obj.close();
            outStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /** loadObject läser ett serialiserat objekt och returnerar
     * ett användbart java-objekt.
     *
     * @param fileName
     * @return Object
     */
    public static Object loadObject(String fileName) {

        Object retObj = null;

        try {

            // Man kan nästla FileInputStream i ObjectInputStream om man inte vill
            // instansiera dem i skilda objekt (som vi gör ovan i saveObject())
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream(fileName));

            retObj = obj.readObject();

            obj.close();

        } catch (FileNotFoundException e) {
            System.out.println("No savefile found.");
        } catch (InvalidClassException e) {
            System.out.println("Invalid class, save file unusable.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");

        }

        return retObj;

    }

}