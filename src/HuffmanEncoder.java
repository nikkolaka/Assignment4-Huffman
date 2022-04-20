import java.io.IOException;

public class HuffmanEncoder {
    private String inputFileName = ".\\src\\WarAndPeace.txt";
    private String outputFileName = ".\\src\\WarAndPeace-compressed.bin";
    private String codesFileName = ".\\src\\WarAndPeace-codes.txt";
    private BookReader book = new BookReader(inputFileName);
    private MyOrderedList<FrequencyNode> frequencies = new MyOrderedList<>();
    private HuffManNode huffmanTree;
    private MyOrderedList<CodeNode> codes = new MyOrderedList<>();
    private byte[] encodedText;



    public HuffmanEncoder() throws IOException {
    //The constructor should call the helper methods in the correct order to carry out Huffman’s algorithm
    countFrequency();
    }
    private void countFrequency(){
    //This method counts the frequency of each character in the book and stores it in frequencies.
    //Iterate through the text character by character maintaining counts in frequencies.
    //The counts are stored in FrequencyNodes.
    //It should output the time it takes to count the frequencies
        long duration = 0;
        long start = System.currentTimeMillis();

        for (int i = 0; i < book.book.length(); i++) {
            FrequencyNode ch = new FrequencyNode();
            ch.character = book.book.charAt(i);

            if(frequencies.binarySearch(ch) != null){
                ch.count = frequencies.binarySearch(ch).count + 1;
                frequencies.remove(ch);
                frequencies.add(ch);

            } else{
                frequencies.add(ch);
            }
        }

        long now = System.currentTimeMillis();
        duration = now - start;
        System.out.println("It took "+duration+" ms");
        System.out.println(frequencies);



    }
    private void buildTree(){
    //This method builds the Huffman tree and extracts the codes from it, storing them in codes.
    //It does so by carrying out these steps:
    //Create a single Huffman node for each character weighted by its count.
    //Add all the nodes to a priority queue.
    //Merge Huffman nodes until only a single tree remains.
    //Store the root of the remaining tree in huffmanTree.
    //Extract the codes from the tree and store them in codes using the recursive helper function like this:
        //extractCodes(huffmanTree,"");
    //It should output the time it takes to build the tree and extract the codes.

    }
    private void extractCode(HuffManNode root, String code){
    //A recursive method that traverses the Huffman tree to extract the codes stored in it.
    //This method will conduct a recursive depth-first traversal of the Huffman tree.
    //The path of left and right moves is stored in the code parameter by adding “0” for left traversals and “1” for right traversals.
    //When a leaf is reached the code is stored in the codes list.

    }
    private void encode(){
    //Uses the book and codes to create encodedText.
    //For each character in text, append the code to an intermediate string.
    //Convert the string of character into a list of bytes and store it in encodedText.
    //You can convert a string of ‘0’s and ‘1’s to a byte with this line:
        //byte b = (byte)Integer.parseInt(str,2);
    //It should output the time it takes to encode the text.


    }
    private void writeFiles(){
    //Writes the contents of encodedText to the outputFileName and the contents of codes to codesFileName.
    //It should output the time it takes to write the files.
    }

    class FrequencyNode implements Comparable<FrequencyNode>{
        Character character;
        Integer count = 0;

        public int compareTo(FrequencyNode other){
            return this.character.compareTo(other.character);
        }
        public String toString(){
            return character+":"+count;
        }



    }
    class HuffManNode implements Comparable<HuffManNode>{
        Character character;
        Integer weight;
        HuffManNode left;
        HuffManNode right;

        public HuffManNode(Character ch, Integer wt){
            this.character = ch;
            this.weight = wt;
        }
        public HuffManNode(HuffManNode left, HuffManNode right){
            this.left = left;
            this.right = right;
        }

        public int compareTo(HuffManNode other){
            return this.weight.compareTo(other.weight);
        }
        public String toString(){
            return character+":"+weight;
        }
    }
    class CodeNode implements Comparable<CodeNode>{
        Character character;
        String code;
        public int compareTo(CodeNode other){
            return this.character.compareTo(other.character);
        }
        public String toString(){
            return character+":"+code;
        }
    }

}

