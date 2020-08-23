package LandersWorks;
//Elyahu Jacobi
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CaesarCypher {
    static int LETTERS_IN_ALPHABET = 26;
    public static void main(String[] args) {
        encrypt("Decrypted.txt","Encrypted.txt", 25);
        decrypt("Encrypted.txt","Decrypted.txt", 25);
    }

    private static void encrypt(String sourceFilename, String destinationFilename, int letterShift) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(sourceFilename);// Contents of file are: ABCDEFGHijklmopqrstuvwxyz
            fileOutputStream = new FileOutputStream(destinationFilename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int letter = 0;
        do {
            try {
                if ((letter = fileInputStream.read()) == -1){ //-1 means it's the end of the file
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (letter <= 96 && letter >= 91){//non letters between the alphabets
                    fileOutputStream.write((char)letter);
                }
                if (letter > 122 || letter < 64){//non letters will just be written
                    fileOutputStream.write((char)letter);
                }else {//letters
                    if (letter >= 65 && letter <= 90){
                        letter = (letter + letterShift - 'A') % LETTERS_IN_ALPHABET+ 'A';
                    fileOutputStream.write((char) letter);//output of capital letters
                    } else {
                        if (letter <= 122 && letter >= 97) {
                            letter = (letter + letterShift - 'a') % LETTERS_IN_ALPHABET+ 'a';
                            fileOutputStream.write((char) letter);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (true);
    }
    private static void decrypt(String sourceFilename, String destinationFilename, int letterShift) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(sourceFilename);// Contents of file are: ABCDEFGHijklmopqrstuvwxyz
            fileOutputStream = new FileOutputStream(destinationFilename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int letter = 0;
        do {
            try {
                if ((letter = fileInputStream.read()) == -1){ //-1 means it's the end of the file
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (letter <= 96 && letter >= 91){//non letters between the alphabets
                    fileOutputStream.write((char)letter);
                }
                if (letter > 122 || letter < 64){//non letters will just be written
                    fileOutputStream.write((char)letter);
                }else {//letters
                    if (letter >= 65 && letter <= 90){
                        letter = (letter - letterShift + 'A') % LETTERS_IN_ALPHABET - 'A';
                        fileOutputStream.write((char) letter);//output of capital letters
                    } else {
                        if (letter <= 122 && letter >= 97) {
                            letter = (letter - letterShift + 'a') % LETTERS_IN_ALPHABET - 'a';
                            fileOutputStream.write((char) letter);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (true);
    }
}
