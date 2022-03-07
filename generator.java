import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.Files;

public class generator {
    public static void main(String[] args) {
        int co = 0;
        try {
            FileInputStream f = new FileInputStream("liste.txt");
            Scanner scan = new Scanner(f);

            while (scan.hasNextLine()) {
                scan.nextLine();
                co++;
            }
            scan.close();
        } catch (IOException err) {
            err.printStackTrace();
        }

        String[] li1 = new String[co];
        String[] li2 = new String[co];

        co = 0;
        try {
            FileInputStream f = new FileInputStream("liste.txt");
            Scanner scan = new Scanner(f);

            while (scan.hasNextLine()) {
                StringTokenizer str = new StringTokenizer(scan.nextLine(), "\t");
                int po = 0;
                while (str.hasMoreElements()) {
                    if (po == 0) {
                        li1[co] = str.nextElement().toString();
                        po++;
                    } else {
                        String asc = new String(str.nextElement().toString().getBytes(), StandardCharsets.UTF_8);
                        li2[co] = asc;
                    }
                }
                co++;
            }
            scan.close();
        } catch (IOException err) {
            err.printStackTrace();
        }

        co = 0;
        try{
            FileInputStream file = new FileInputStream("staff.txt");
            Scanner scan = new Scanner(file);

            while(scan.hasNextLine()){
                scan.nextLine();
                co++;
            }
            scan.close();
        } catch (IOException err) {
            err.printStackTrace();
        }

        String[] staff = new String[co];
        co = 0;
        try {
            FileInputStream f = new FileInputStream("staff.txt");
            Scanner scan = new Scanner(f);

            while (scan.hasNextLine()) {
                staff[co] = scan.nextLine().toString();
                co++;
            }
            scan.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
        Arrays.sort(staff);

        String filename = "html/index.html";
        String encod = "UTF-8";
        try {
            PrintWriter wr = new PrintWriter(filename, encod);
            // mettre code html
            wr.println(
                    "<!DOCTYPE html> <meta charset='UTF-8'>  <head> <title>GO Sécuri</title> <link rel='stylesheet' href='style.css'/> </head>");
            wr.println(
                    "<body class='bck'> <div> <img src='/png/GOS.png' alt=''></div>  <div class='round'> <div class='ma'>");
           
            

            for (String nom : staff) {

                String srcPath = "html/png/" + nom + ".png";
                String destPath = "html/png/";
                File srcFile = new File(srcPath);
                File destFile = new File(destPath + srcFile.getName());

                try {
                    Files.copy(srcFile.toPath(), destFile.toPath(), REPLACE_EXISTING);
                } catch (Exception err) {
                    System.out.println(err);
                }

                
                String Nom = nom.substring(0, 1).toUpperCase() + nom.substring(1);
                wr.println("<tr><a href='txt/" + nom + ".html'>" + Nom + "</a></tr></br>");
            
                

                String fileName2 = "html/txt/" + nom + ".html";
                PrintWriter wr2 = new PrintWriter(fileName2, encod);

                wr2.println(
                        "<!doctype html>  <html lang='fr'> <head> <meta charset='utf-8'> <title>GO Securi</title> <link rel='stylesheet' href='style2.css'> <link rel='icon' href='favicon.ico' /> </head>");
                wr2.println("<body class='bck'> <div class='round'> <div class='ma'> <table> <tr class='haut'><td class='gauche'> <div>" + Nom
                        + "</div> </td>");
                wr2.println("<td> <img src='/png/" + nom + ".png' class='CNI'></td> </tr> <tr> <td class='bas'></div> </div>");
                co = 0;
                try {
                    FileInputStream f2 = new FileInputStream("html/txt/" + nom + ".txt");
                    Scanner scan2 = new Scanner(f2);

                    while (scan2.hasNextLine()) {
                        scan2.nextLine();
                        co++;
                    }
                    scan2.close();
                } catch (IOException err) {
                    err.printStackTrace();
                }
                String[] li3 = new String[co];
                co = 0;
                try {
                    FileInputStream f2 = new FileInputStream("html/txt/" + nom + ".txt");
                    Scanner scan2 = new Scanner(f2);

                    while (scan2.hasNextLine()) {
                        if (co > 4) {
                            li3[co - 5] = scan2.nextLine().toString();
                        } else {
                            scan2.nextLine();
                        }
                        co++;
                    }
                    scan2.close();
                } catch (IOException err) {
                    err.printStackTrace();
                }
                wr2.println("<div class='lic'>");
                for (int i = 0; i < li1.length; i++) {
                    boolean verif = false;
                    for (int x = 0; x < li3.length; x++) {
                        if (li3[x] != null && li1[i] != null) {
                            if (li3[x].equals(li1[i])) {
                                verif = true;
                            }
                        }
                    }
                    if (verif == true) {
                        wr2.println(li1[i] + " <input type='checkbox' checked onclick='return false;'> <br>");
                    } else {
                        wr2.println(li1[i] + " <input type='checkbox' onclick='return false;'><br>");
                    }
                }
                wr2.println("</div>");
                wr2.println("</td> </tr></table> </div></body> </html>");
                wr2.close();
            }
            wr.println("</div></div></body>");
            wr.println("<footer> <p>*GO Sécuri tous droits réservé Entreprise titulaire </p> </footer> </html>");

            wr.close();
        } catch (IOException err) {
            System.out.println("An error occurred.");
            err.printStackTrace();
        }

    }
}
