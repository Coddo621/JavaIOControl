package com.example;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Func {
    static void createfile(){
        Scanner input = new Scanner(System.in);
        try{
            System.out.println("Input file path, name and extension: ");
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
            System.out.println("Input file path, name and extension of the file you want to write in: ");
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
            System.out.println("Input file path, name and extension of the file you want to read: ");
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
        System.out.println("Input file path, name and extension of the file you want to inspect: ");
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
        System.out.println("Input path of the directory you want to create: ");
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
        System.out.println("Input path of the directory you want to delete: ");
        String dirpath = input.nextLine();
        File dir = new File(dirpath);
        if(dir.delete()){
            System.out.println("Directory deleted: "+dir.getName());
        }else{
            System.out.println("Couldn't delete directory");
        }
        input.close();
    }
}
