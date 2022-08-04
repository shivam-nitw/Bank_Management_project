package com.bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bank {
	public static void main(String args[]) //main class of bank
		throws IOException
	{

		BufferedReader sc = new BufferedReader(
			new InputStreamReader(System.in));
		String name = "";
		int pass_code;
		int ac_no;
		int ch;

		while (true) {
			System.out.println(
				"\n ->|| Welcome to Amdocs Bank ||<- \n");
			System.out.println("1)New User please Create Account");
			System.out.println("2)Existing user please Login Account");

			try {
				System.out.print("\n Please Enter Your Choice:"); //user input
				ch = Integer.parseInt(sc.readLine());

				switch (ch) {
				case 1:
					try {
						System.out.print(
								"Please Enter account number:");
							ac_no = Integer.parseInt(
								sc.readLine());
						System.out.print(
							"Please Enter Unique UserName:");
						name = sc.readLine();
						System.out.print(
							"Please Enter New Password:");
						pass_code = Integer.parseInt(
							sc.readLine());

						if (bankManagement.createAccount(ac_no,
								name, pass_code)) {
							System.out.println(
								"MSG : Account Created Successfully!\n");
						}
						else {
							System.out.println(
								"ERR : Account Creation Failed!\n");
						}
					}
					catch (Exception e) {
						System.out.println(
							" ERR : Enter Valid Data::Insertion Failed!\n");
					}
					break;

				case 2:
					try {
						System.out.print(
							"Enter UserName:");
						name = sc.readLine();
						System.out.print(
							"Enter Password:");
						pass_code = Integer.parseInt(
							sc.readLine());

						if (bankManagement.loginAccount(
								name, pass_code)) {
							System.out.println(
								"MSG : Logout Successfully!\n");
						}
						else {
							System.out.println(
								"ERR : login Failed!\n");
						}
					}
					catch (Exception e) {
						System.out.println(
							" ERR : Enter Valid Data::Login Failed!\n");
					}

					break;

				default:
					System.out.println("Invalid Entry!\n");
				}

				if (ch == 5) {
					System.out.println(
						"Exited Successfully!\n\n Thank You :)");
					break;
				}
			}
			catch (Exception e) {
				System.out.println("Enter Valid Entry!");
			}
		}
		sc.close();
	}
}
