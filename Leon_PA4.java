
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class Leon_PA4
    {
        Set<String> uniqueWords = new HashSet<String>();

        public static void main(String []args){
            //System.out.println("Hello World");
        }

        public void remove(String dataFile){
            //data file is a file path
            //open the datafile and copy everything into str1
            // this.dataFile = dataFile;

            // String str1 = "Hello Hello what is your name sir";
            // String[] words = str1.split(" ");

            Set<String> tempWords = new HashSet<String>();
            try {
                tempWords = fileOpp(dataFile);
            }
            catch(IOException e) {
                e.printStackTrace();
            }

            //file ops returns the set
            //Unique words fiilters the unique words


            for (String word : tempWords) {
                if (!uniqueWords.contains(word))
                {
                    uniqueWords.add(word);
                }
                else
                    uniqueWords.remove(word);
            }
            //print , just for testing
            //System.out.println(uniqueWords.toString());
        }

        public void write(String outputFile)
                throws IOException
        {

            //  this.outputFile = outputFile;
            //take everything in uniquewords and write it to
            //the file pointed to by output file

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true));



            for (String word : uniqueWords) {
                writer.append(word);
                writer.append(' ');

            }
            writer.close();




        }


        public  Set<String> fileOpp(String fileName) throws IOException
        {
            FileInputStream in = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = br.readLine();


            Set<String> temps = new HashSet<String>();

            while(strLine != null)
            {
                String a[]=strLine.split(" ");

                for(int i=0;i<a.length;i++)
                {
                    if(a[i].length()>0)
                    {
                        temps.add(a[i]);
                    }

                }

                strLine = br.readLine();
            }
            br.close();
            return temps;

        }


    }

    class Application
    {
        public static void main(String[] args)
        {
            Leon_PA4 dr = new Leon_PA4();
            dr.remove("problem1.txt");
            try {
                dr.write("unique_words.txt");
            } catch (Exception e) {}


        }
    }

