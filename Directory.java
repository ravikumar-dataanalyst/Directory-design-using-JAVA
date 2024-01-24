   import java.io.*;
   import java.util.*;
    class Simple{  
        public static void main(String args[])
        {  
        
         int no_of_names;
        // FileWriter writer = new FileWriter("students.txt");
         Scanner myInput = new Scanner( System.in );
        Scanner mystrinput=new Scanner(System.in);
         System.out.println("how many names you want to Enter ?  ");
         no_of_names= myInput.nextInt();
         String[] strAr= new String[no_of_names]; 
         for(int k=0; k<no_of_names; k++)
         {
                 
                System.out.println("Enter the Name");  
         	String str=mystrinput.nextLine();
         	strAr[k]=str;
         
               
         
         
        } 
        sortLexicographically(strAr);
        try
        {
        printArray(strAr);
        
        }catch(Exception e)
        {
        
        }
        System.out.println("Which name you want to remove from file ??");
        String stringToRemove=mystrinput.nextLine();
        System.out.println("removed String is"+stringToRemove);
        
        
        try
        {
        removeLineMethod(stringToRemove);
        }catch(Exception e)
        {
        
        }
        System.out.println("name is successfully removed from list");
        try
        {
        System.out.println("The Content of the file in Reverse Order is as follow");
        readAndPrintInReverseOrder();
        }catch(Exception e)
        {
        
        }
        
        
         
    }  
    
     public static void
    sortLexicographically(String strArr[])
    {
        for (int i = 0; i < strArr.length; i++) {
            for (int j = i + 1; j < strArr.length; j++) 
            {
              
                 if (strArr[i].compareToIgnoreCase(strArr[j])> 0) 
                 {
                    String temp = strArr[i];
                    strArr[i] = strArr[j];
                    strArr[j] = temp;
                }
                
            }
        }
    }
  
    // this function prints the array passed as argument
    public static void printArray(String strArr[]) throws Exception 
    {
        
       // for (String string : strArr)
          //  System.out.print(string + "\n");
       // System.out.println();
       
       File path
            = new File("Students.txt");
 
        // Declaring the print writer with path
        PrintWriter pw = new PrintWriter(path);
 
        // Now calling writer() method with string
        for(int i=0; i<strArr.length; i++)
        {
        pw.write(strArr[i]+"\n");
        }

        // Flushing the print writer
        pw.flush();
 
        // Lastly closing the printwriter
        // using the close() method
        pw.close(); 
       
       
       
     
    }
    
    
    public static void removeLineMethod(String nameToRemove) throws IOException 
    {
   File inputFile = new File("Students.txt");
   File tempFile = new File("TempWordlist.txt");

   BufferedReader reader = new BufferedReader(new FileReader(inputFile));
   BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
   String currentLine;

   while((currentLine = reader.readLine()) != null)
 {
   String trimmedLine = currentLine.trim();
   if(trimmedLine.equals(nameToRemove)) continue;
   writer.write(currentLine + "\n");
 }
   reader.close();
   writer.close();
   inputFile.delete();
   tempFile.renameTo(inputFile);
 }
    
    
  public static void readAndPrintInReverseOrder() throws IOException {

    String path = "Students.txt";

    BufferedReader br = null;

    try {
        br = new BufferedReader(new FileReader(path));
        Stack<String> lines = new Stack<String>();
        String line = br.readLine();
        while(line != null) {
            lines.push(line);
            line = br.readLine();
        }

        while(! lines.empty()) {
            System.out.println(lines.pop());
        }

    } finally {
        if(br != null) {
            try {
                br.close();   
            } catch(IOException e) {
                // can't help it
            }
        }
    }
}
       
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
