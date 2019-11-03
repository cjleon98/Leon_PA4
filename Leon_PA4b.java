import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class Leon_PA4b
    {
        Map<String, Integer> wordCounter = new HashMap<String, Integer> ();

        public static void main(String []args){
            //System.out.println("Hello World");
        }

        public void count(String dataFile){


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
                if (!wordCounter.containsKey(word)) {  // first time we've seen this string
                    wordCounter.put(word, 1);
                }
                else {
                    int count = wordCounter.get(word);
                    wordCounter.put(word, count + 1);
                }
            }

            //print , just for testing
            //System.out.println(uniqueWords.toString());
        }

        public void write(String outputFile)
                throws IOException
        {


            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true));



            for (String word : wordCounter.keySet()) {
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
            Leon_PA4b dc = new Leon_PA4b();
            dc.count("problem2.txt ");
            try {
                dc.write("unique_word_counts.txt.");
            } catch (Exception e) {}


        }
    }

