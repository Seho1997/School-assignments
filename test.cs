using System;
using System.IO;
using System.Text.RegularExpressions;
using System.Linq;
class WordCounter {
    static void Main() {
        string inputFileName = "text.txt"; //File Path with file name
        StreamReader strmReader = new StreamReader(inputFileName);
        string text = System.IO.File.ReadAllText(@ "C:\Files\MyFileName.txt");
        Regex reg_exp = new Regex("[^a-zA-Z0-9]");
        text = reg_exp.Replace(text, " ");
        string[] words = text.Split(new char[] {
            ' '
        }, StringSplitOptions.RemoveEmptyEntries);
        var word_query = (from string word in words orderby word select word).Distinct();
        string[] result = word_query.ToArray();
        int counter = 0;
        string delim = " ,.";
        string[] fields = null;
        string line = null;
        while (!strmReader.EndOfStream) {
            line = strmReader.ReadLine(); //Read a line and split it into the words
            line.Trim();
            fields = line.Split(delim.ToCharArray(), StringSplitOptions.RemoveEmptyEntries);
            counter += fields.Length; //count
            foreach(string word in result) {
                CountStringOccurrences(text, word);
            }
        }
        strmReader.Close();
        Console.WriteLine("Total word count is {0}", counter);
        Console.ReadLine();
    }
    public static void CountStringOccurrences(string text, string word) {
        int count = 0;
        int i = 0;
        while ((i = text.IndexOf(word, i)) != -1) {
            i += word.Length;
            count++;
        }
        Console.WriteLine("{0} {1}", count, word);
    }
}