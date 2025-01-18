package com.hibernate.image;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class UseIndianTeam {

	public static void main(String[] args) throws IOException{
		Scanner kb = new Scanner(System.in);
		IndianTeamService service = new IndianTeamService();
		IndianTeam player;
		while(true) {
			player = new IndianTeam();
			
			System.out.println("Enter player Jersey number");
			player.setJerseyNo(kb.nextInt());
			
			System.out.println("Enter player name");
			kb.nextLine();
			player.setName(kb.nextLine());
			
			System.out.println("Enter player role");
			player.setRole(kb.nextLine());
			
			System.out.println("Enter image name with extention");
			FileInputStream fis = new FileInputStream("src/main/java/images/"+kb.next());
			byte[] image = new byte[fis.available()];
			fis.read(image);
			player.setImage(image);
			
			service.insert(player);
			
			System.out.println("Do you want to add one more player(Y/N): ");
			String res = kb.next();
			fis.close();
			if(res.equalsIgnoreCase("N")) {
				System.out.println("Thanks for using the app...");
				break;
			}
			
		}
		
		kb.close();
	}

}
