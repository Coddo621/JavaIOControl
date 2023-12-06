package com.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){
		    System.out.println("1 Create file\n2 Write to file\n3 Read file\n4 File info\n5 Create directory\n6 Delete file\n7 Delete directory");
            System.out.println("To exit program hold CTRL and press c");
            int choice = input.nextInt();

            switch(choice) {
				case 1:
					Func.createfile(input);
					break;
				case 2:
					Func.writefile(input);
					break;
				case 3:
					Func.readfile(input);
					break;
				case 4:
					Func.fileinfo(input);
					break;
				case 5:
					Func.createdir(input);
					break;
				case 6:
					Func.deletefile(input);
					break;
				case 7:
					Func.deletedirectory(input);
				default:
					System.out.println("Error: Undefined case");
					break;
			}
        }
    }
}