using System;
using System.IO;
using System.Text.RegularExpressions;
using System.Linq;

class CountWord {
    static void Main() {
            string inputFileName = "text1.txt";
            StreamReader lnReader = new StreamReader(inputFileName);
            string text = System.IO.File.ReadAllText(@ "C:\Files\text1.txt");
            Regex reg_exp = new Regex("[^a-zA-Z0-9]");
            text = reg_exp.Replace(text, " ");
            string[] words = text.Split(new char[] {
                ' '
            }, StringSplitOptions.RemoveEmptyEntries);
            var word_problem = (from string word in words orderby word select word).Distinct();
            string[] result = word_problem.ToArray();
            int counter = 0;
            string delim = " ,.";
            string[] fields = null;
            string line = null;
            while (!lnReader.EndOfStream) {
                line = lnReader.ReadLine();
                line.Trim();
                fields = line.Split(delim.ToCharArray(), StringSplitOptions.RemoveEmptyEntries);
                counter += fields.Length;
                foreach(string word in result) {
                    StringOccurrences(text, word);
                }
            }
            lnReader.Close();
            Console.ReadLine;
        }
        public static void StringOccurrences(string text, string word) {
            int count = 0;
            int i = 0;
            while ((i = text.IndexOf(word, i)) != -1) {
                i += word.Length;
                count++;
            }
            Console.WriteLine("{0} {1}", count, word);
        }
    }


