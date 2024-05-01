package com.example;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
		System.out.println("1 Create file\n2 Write to file\n3 Read file\n4 File info\n5 Create directory\n6 Delete file\n7 Delete directory\n8 List files and directories at given path\n9 Get file permissions\n10 Rename file or directory\n11 Count words in file\n12 Move file");
        int choice = input.nextInt();
        switch(choice) {
			case 1:
				Func.createfile();
				break;
			case 2:
				Func.writefile();
				break;
			case 3:
				Func.readfile();
				break;
			case 4:
				Func.fileinfo();
				break;
			case 5:
				Func.createdir();
				break;
			case 6:
				Func.deletefile();
				break;
			case 7:
				Func.deletedirectory();
				break;
			case 8:
				Func.listdirectory();
				break;
			case 9:
				Func.getfileperms();
				break;
			case 10:
				Func.filedirectoryrename();
				break;
			case 11:
				Func.wordcount();
				break;
			case 12:
				Func.movefile();
				break;
			default:
				System.out.println("Error: Undefined case");
				break;
		}
		input.close();
    }
}