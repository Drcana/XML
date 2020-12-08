package ftn.unc.as.rs.xml.poc.dom;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class DomMain {

    public static void main(String args[]) {
        while (true) {
            System.out.println("Odaberite opciju:\n");
            System.out.println("0 - Parse document \n1 - Write document \n2 - Exit\n");

            Scanner scanner = new Scanner(System.in);
            Integer option = Integer.valueOf(scanner.next());

            switch (option) {
                case 0:
                    openParserMenu();
                    break;
                case 1:
                    openWriterMenu();
                    break;
                case 2:
                    System.exit(0);
                default:
                    System.out.println("Wrong input");
                    return;
            }
        }
    }

    private static void openParserMenu() {

        boolean theEnd = false;

        while (!theEnd) {

            DOMParser domParser = new DOMParser();

            String filePath = "src\\main\\resources\\static\\data\\xml\\";

            System.out.println("[INFO] DOM Parser");

            System.out.println("Odaberite file za parsiranje:\n");
            System.out.println("0 - Zahtev \n" +
                    "1 - Zalba protiv odluke \n" +
                    "2 - Zalba protiv cutanja \n" +
                    "3 - Obavestenje \n" +
                    "4 - Resenje\n" +
                    "5 - Nazad\n");

            Scanner scanner = new Scanner(System.in);
            Integer option = Integer.valueOf(scanner.next());

            switch (option) {
                case 0:
                    filePath += "zahtev.xml";
                    domParser.buildDocument(filePath);
                    domParser.printDocument();
                    break;
                case 1:
                    filePath += "zalbaProtivOdluke.xml";
                    domParser.buildDocument(filePath);
                    domParser.printDocument();
                    break;
                case 2:
                    filePath += "zalbaProtivCutanja.xml";
                    domParser.buildDocument(filePath);
                    domParser.printDocument();
                    break;
                case 3:
                    filePath += "obavestenje.xml";
                    domParser.buildDocument(filePath);
                    domParser.printDocument();
                    break;
                case 4:
                    filePath += "resenje.xml";
                    domParser.buildDocument(filePath);
                    domParser.printDocument();
                    break;
                case 5:
                    theEnd = true;
                    break;
                default:
                    System.out.println("Wrong input, please try again.");
                    break;
            }
        }
    }

    private static void openWriterMenu() {
        boolean theEnd = false;

        while (!theEnd) {
            DOMWriter domWriter = new DOMWriter();
            domWriter.createDocument();

            System.out.println("[INFO] DOM Writer");
            System.out.println("Odaberite dokument:\n");
            System.out.println("0 - Zahtev\n" +
                    "1 - Zalba protiv odluke\n" +
                    "2 - Zalba protiv cutanja\n" +
                    "3 - Obavestenje\n" +
                    "4 - Resenje\n" +
                    "5 - Nazad\n");

            Scanner scanner = new Scanner(System.in);
            Integer option = Integer.valueOf(scanner.next());

            switch (option) {
                case 0:
                    domWriter.generateZahtevDOM();
                    printAndSaveXmlData(domWriter);
                    break;
                case 1:
                    domWriter.generateZalbaOdlukeDOM();
                    printAndSaveXmlData(domWriter);
                    break;
                case 2:
                    domWriter.generateZalbaCutanjaDOM();
                    printAndSaveXmlData(domWriter);
                    break;
                case 3:
                    domWriter.generateObavestenjeDOM();
                    printAndSaveXmlData(domWriter);
                    break;
                case 4:
                    domWriter.generateResenjeDOM();
                    printAndSaveXmlData(domWriter);
                    break;
                case 5:
                    theEnd = true;
                    break;
                default:
                    System.out.println("Unos nije validan, pokusajte ponovo.");
                    break;
            }
        }
    }

    private static void printAndSaveXmlData(DOMWriter domWriter) {
        domWriter.transform(System.out);

        try {
            domWriter.transform(new FileOutputStream("src/main/resources/static/data/xml/out.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
