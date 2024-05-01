package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Func {
    static void createfile(){
        Scanner input = new Scanner(System.in);

        try{
            System.out.println("Input the file path, name and extension of the file you want to create: ");
            String filepath = input.nextLine();

            File file = new File(filepath);

            if(file.createNewFile() == true){
                System.out.println("File created: "+file.getName());
            }else{
                System.out.println("File already exists");
            }
        }catch(IOException error){
            System.out.println("Exception IO Error");
            error.printStackTrace();
        }

        input.close();
    }

    static void writefile(){
        Scanner input = new Scanner(System.in);

        try{	
            System.out.println("Input the file path, name and extension of the file you want to write in: ");
            String filepath = input.nextLine();
            
            FileWriter file = new FileWriter(filepath);
            System.out.println("Input text: ");
            file.write(input.nextLine());
            file.close();
        }catch(IOException error){
            System.out.println("Exception IO Error");
            error.printStackTrace();
        }

        input.close();
    }
    
    static void readfile(){
        Scanner input = new Scanner(System.in);

        try{
            System.out.println("Input the file path, name and extension of the file you want to read: ");
            String filepath = input.nextLine();
            
            File file = new File(filepath);
            
            Scanner read = new Scanner(file);
            
            while(read.hasNextLine()) {
                System.out.println(read.nextLine());
            }
            
            read.close();
        }catch(FileNotFoundException error){
            System.out.println("Exception IO Error");
            error.printStackTrace();
        }

        input.close();
    }
    
    static void fileinfo(){
        Scanner input = new Scanner(System.in);

        System.out.println("Input the file path, name and extension of the file you want to inspect: ");
        String filepath = input.nextLine();
        File file = new File(filepath);

        if(file.exists()){
            System.out.println("Name: "+filepath+"\nDirectory: "+file.getAbsolutePath()+"\nWriteable: "+file.canWrite()+"\nReadable: "+file.canRead()+"\nSize: "+file.length());
        }else{
            System.out.println("File doesn't exist");
        }

        input.close();
    }
    
    static void createdir(){
        Scanner input = new Scanner(System.in);

        System.out.println("Input the path of the directory you want to create: ");
        String dirpath = input.nextLine();
        File dir = new File(dirpath);

        if(dir.mkdir()){
            System.out.println("Directory created: "+dir.getName());
        }else{
            System.out.println("An error occured while creating directory");
        }

        input.close();
    }
    
    static void deletefile(){
        Scanner input = new Scanner(System.in);

        System.out.println("Input the path of the file you want to delete: ");
        String filepath = input.nextLine();
        File file = new File(filepath);

        if(file.delete()){
            System.out.println("File deleted: "+file.getName());
        }else{
            System.out.println("Couldn't delete file");
        }

        input.close();
    }
    
    static void deletedirectory(){
        Scanner input = new Scanner(System.in);

        System.out.println("Input the path of the directory you want to delete: ");
        String dirpath = input.nextLine();
        File dir = new File(dirpath);

        if(dir.delete()){
            System.out.println("Directory deleted: "+dir.getName());
        }else{
            System.out.println("Couldn't delete directory");
        }

        input.close();
    }

    static void listdirectory(){
        Scanner input = new Scanner(System.in);

        System.out.println("Input the path of the directory you want to list out: ");
        String dirpath = input.nextLine();
        File dir = new File(dirpath);
        File[] filelist = dir.listFiles();

        if(filelist != null){
            for(int i = 0; i  < filelist.length; i++){
                if(filelist[i].isFile()){
                    System.out.println("File: " + filelist[i].getName());
                }else if(filelist[i].isDirectory()){
                    System.out.println("Directory: " + filelist[i].getName());
                }
            }
        }else{
            System.out.println("You haven't selected a directory to scan");
        }

        input.close();
    }

    static void getfileperms(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input the path of the file you want to get the permissions of: ");
        String filepath = input.nextLine();
        File file = new File(filepath);

        if(file.exists()){
            System.out.println("Write: " + file.canWrite());
            System.out.println("Read: " + file.canRead());
            System.out.println("Execute: " + file.canExecute());
        }else{
            System.out.println("File not found");
        }

        input.close();
    }

    static void filedirectoryrename(){
        Scanner input = new Scanner(System.in);

        System.out.println("Input the path of the file or directory you want to rename: ");
        String filepath = input.nextLine();
        System.out.println("Input the name you want to rename the file or directory into: ");
        String renamenewname = input.nextLine();
        File file = new File(filepath);
        String renamestring = file.getParent() + "/" + renamenewname;
        File rename = new File(renamestring);
        boolean renameflag = file.renameTo(rename);

        if(renameflag == true){
            System.out.println("File renamed to: " + rename.getName());
        }else{
            System.out.println("You haven't selected the original and new file or directory name");
        }

        input.close();
    }

    static void wordcount() throws IOException{
        String line;
        int count = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Input the path of the file you want to count the words in: ");
        String filepath = input.nextLine();
        FileReader file = new FileReader(filepath);
        BufferedReader reader = new BufferedReader(file);

        while((line = reader.readLine()) != null){
            String words[] = line.split(" ");
            count = count + words.length;
        }

        System.out.println("Number of words in file: "+count);

        input.close();
        reader.close();
    }

    static void movefile(){
        Scanner input = new Scanner(System.in);

        System.out.println("Input the path of the file you want to move: ");
        String filepath = input.nextLine();
        System.out.println("Input the path you want to move the file to:  ");
        String movepath = input.nextLine();
        File file = new File(filepath);
        File move = new File(movepath);
        boolean moveflag = file.renameTo(move);

        if(moveflag == true){
            System.out.println("File moved to: " + move.getAbsolutePath());
        }else{
            System.out.println("You haven't selected the path you want to move the file to");
        }

        input.close();
    }
}
