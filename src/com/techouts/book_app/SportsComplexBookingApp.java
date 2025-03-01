package com.techouts.book_app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SportsComplexBookingApp {
	static Scanner sc = new Scanner(System.in);

	public static void bookSlot(Sport sport, String playerName) {
		try {
			System.out.print("Which slot would you like to book?");
			int slotNumber = sc.nextInt() - 1;
			sc.nextLine();

			List<String> slots = sport.getSlot();

			if (slotNumber < 0 || slotNumber >= slots.size()) {
				System.err.println("The selected slot is invalid. Kindly try again...!!!");
				return;
			}

			String bookedSlot = slots.get(slotNumber);
			sport.bookSlot(slotNumber);
			System.out.println();
			System.out.println("Booking successful!");
			System.out.println("User: " + playerName);
			System.out.println("Sport: " + sport.getName());
			System.out.println("Slot: " + bookedSlot);
		} catch (Exception e) {
			System.err.println("The booking of the slot has failed....");
			sc.nextLine();
		}
	}

	public static void main(String[] args) {

		SportsComplex sportsComplex = new SportsComplex();

		restart: while (true) {
			try {
				System.out.print("Please enter the player's name : ");
				String name = sc.nextLine();

				if (Validation.isValidName(name, "^[A-Za-z ]+$")) {
					sportsComplex.displaySports();

					System.out.print("Kindly enter your choice : ");
					int choice = sc.nextInt();

					sc.nextLine();
					switch (choice) {
					case 1: {
						Sport sport = sportsComplex.getSport().get(choice - 1);
						sportsComplex.displaySlot(sport);
						boolean checkSlots = sportsComplex.checkSlots(choice - 1);

						if (checkSlots) {
							System.out.println();
							System.out.println("All slots are fully booked. Please try with an available game...");
							System.err.println();
							f: while (true) {
								try {
									System.out.print("Would you like to try other games?  [Y/N] : ");
									char ch = sc.nextLine().toUpperCase().charAt(0);

									if (ch == 'N') {
										System.out.println("Thank You...");

										break;
									} else if (ch == 'Y') {
										continue restart;
									} else {
										System.err.println("The input provided is incorrect.");
										continue f;
									}
								} catch (Exception e) {
									System.err.println("Please Enter Given Character ...");
									continue f;
								}

							}
						} else {

							inner: while (true) {
								boolean flag = false;
								System.out.println();

								bookSlot(sport, name);
								System.out.println();
								System.out.println("The available slots are::-");
								List<String> slot = sport.getSlot();
								for (int i = 0; i < slot.size(); i++) {
									System.out.println("Slot " + (i + 1) + ": " + slot.get(i));
								}

								fail: while (true) {
									try {
										System.out.print("Would you like to allocate another slot?  [Y/N] : ");
										char charAt = sc.nextLine().toUpperCase().charAt(0);

										if (charAt == 'N') {
											System.out.println("Thank You...");
											flag = true;
											break;
										} else if (charAt == 'Y') {

											checkSlots = sportsComplex.checkSlots(choice - 1);
											if (checkSlots) {
												System.err.println(
														"All slots have been booked. Please try with other games...!!!");

												f: while (true) {
													try {
														System.out
																.print("Would you like to try other games?  [Y/N] : ");
														char ch = sc.nextLine().toUpperCase().charAt(0);

														if (ch == 'N') {
															System.out.println("Thank You...");
															flag = true;
															break;
														} else if (ch == 'Y') {
															continue restart;
														} else {
															System.err.println("The input provided is incorrect.");
															continue f;
														}
													} catch (Exception e) {
														System.err.println("Please Enter Given Character...");
														continue f;
													}
												}
												flag = true;
												break;
											}
											continue inner;
										} else {
											System.err.println("The input provided is incorrect.");
											continue fail;
										}
									} catch (Exception e) {
										System.err.println("Please Enter Given Character...");
										continue fail;
									}
								}
								if (flag) {
									break;
								}
							}
						}
						break;
					}
					case 2: {
						Sport sport = sportsComplex.getSport().get(choice - 1);
						sportsComplex.displaySlot(sport);
						boolean checkSlots = sportsComplex.checkSlots(choice - 1);

						if (checkSlots) {
							System.out.println();
							System.out.println("All slots are booked. Try With Avaiable Game ...!!!");
							System.out.println();
							f: while (true) {
								try {
									System.out.print("Would you like to try other games?  [Y/N] : ");
									char ch = sc.nextLine().toUpperCase().charAt(0);

									if (ch == 'N') {
										System.out.println("Thank You...");

										break;
									} else if (ch == 'Y') {
										continue restart;
									} else {
										System.err.println("The input provided is incorrect...");
										continue f;
									}
								} catch (Exception e) {
									System.err.println("Please Enter Given Character ...");
									continue f;
								}

							}
						} else {

							inner: while (true) {
								boolean flag = false;
								System.out.println();

								bookSlot(sport, name);
								System.out.println();
								System.out.println("The Avaiable Slot Are :-");
								List<String> slot = sport.getSlot();
								for (int i = 0; i < slot.size(); i++) {
									System.out.println("Slot " + (i + 1) + ": " + slot.get(i));
								}

								fail: while (true) {
									try {
										System.out.print("Would you like to allocate another slot?  [Y/N] : ");
										char charAt = sc.nextLine().toUpperCase().charAt(0);

										if (charAt == 'N') {
											System.out.println("Thank You...");
											flag = true;
											break;
										} else if (charAt == 'Y') {

											checkSlots = sportsComplex.checkSlots(choice - 1);
											if (checkSlots) {
												System.err.println(
														"All slots have been booked. Please try with other games.");

												f: while (true) {
													try {
														System.out
																.print("Would you like to try other games?  [Y/N] : ");
														char ch = sc.nextLine().toUpperCase().charAt(0);

														if (ch == 'N') {
															System.out.println("Thank You...");
															flag = true;
															break;
														} else if (ch == 'Y') {
															continue restart;
														} else {
															System.err.println("The input provided is incorrect...");
															continue f;
														}
													} catch (Exception e) {
														System.err.println("Please Enter Given Character...!!!");
														continue f;
													}

												}
												flag = true;
												break;
											}
											continue inner;
										} else {
											System.err.println("The input provided is incorrect...");
											continue fail;
										}
									} catch (Exception e) {
										System.err.println("Please Enter Given Character...!!!");
										continue fail;
									}
								}
								if (flag) {
									break;
								}
							}
						}
						break;
					}
					case 3: {
						Sport sport = sportsComplex.getSport().get(choice - 1);
						sportsComplex.displaySlot(sport);
						boolean checkSlots = sportsComplex.checkSlots(choice - 1);

						if (checkSlots) {
							System.out.println();
							System.out.println("All slots are booked. Try With Avaiable Game ...!!!");
							System.out.println();
							f: while (true) {
								try {
									System.out.print("Would you like to try other games?  [Y/N] : ");
									char ch = sc.nextLine().toUpperCase().charAt(0);

									if (ch == 'N') {
										System.out.println("Thank You...");

										break;
									} else if (ch == 'Y') {
										continue restart;
									} else {
										System.err.println("The input provided is incorrect...");
										continue f;
									}
								} catch (Exception e) {
									System.err.println("Please Enter Given Character ...");
									continue f;
								}

							}
						} else {

							inner: while (true) {
								boolean flag = false;
								System.out.println();

								bookSlot(sport, name);
								System.out.println();
								System.out.println("The Avaiable Slot Are :-");
								List<String> slot = sport.getSlot();
								for (int i = 0; i < slot.size(); i++) {
									System.out.println("Slot " + (i + 1) + ": " + slot.get(i));
								}

								fail: while (true) {
									try {
										System.out.print("Would you like to allocate another slot?  [Y/N] : ");
										char charAt = sc.nextLine().toUpperCase().charAt(0);

										if (charAt == 'N') {
											System.out.println("Thank You...");
											flag = true;
											break;
										} else if (charAt == 'Y') {

											checkSlots = sportsComplex.checkSlots(choice - 1);
											if (checkSlots) {
												System.err.println(
														"All slots have been booked. Please try with other games.");

												f: while (true) {
													try {
														System.out
																.print("Would you like to try other games?  [Y/N] : ");
														char ch = sc.nextLine().toUpperCase().charAt(0);

														if (ch == 'N') {
															System.out.println("Thank You...");
															flag = true;
															break;
														} else if (ch == 'Y') {
															continue restart;
														} else {
															System.err.println("The input provided is incorrect...");
															continue f;
														}
													} catch (Exception e) {
														System.err.println("Please Enter Given Character...!!!");
														continue f;
													}

												}
												flag = true;
												break;
											}
											continue inner;
										} else {
											System.err.println("The input provided is incorrect...");
											continue fail;
										}
									} catch (Exception e) {
										System.err.println("Please Enter Given Character...!!!");
										continue fail;
									}
								}
								if (flag) {
									break;
								}
							}
						}
						break;
					}
					default: {
						System.err.println("Please enter a valid choice...!!!");
					}
					}
				} else {
					throw new UserDefineMessageException("Please enter a valid name....");
				}
			} catch (UserDefineMessageException e) {
				System.err.println(e.getMessage());

				s: while (true) {
					try {
						System.out.print("Would you like to continue? [Y/N] ");
						char charAt = sc.nextLine().toUpperCase().charAt(0);

						if (charAt == 'N') {
							System.out.println("Thank You....");
							break;
						} else if (charAt == 'Y') {
							continue restart;
						} else {
							System.err.println("The input provided is incorrect...");
							continue s;
						}
					} catch (Exception e2) {
						System.err.println("Please Enter Given Charcater...");
						continue s;
					}
				}

			} catch (InputMismatchException e) {
				System.err.println("Enter Valid input...");
				sc.nextLine();
				try {
					System.out.print("Would you like to continue? [Y/N] ");
					char charAt = sc.nextLine().toUpperCase().charAt(0);

					if (charAt == 'N') {
						System.out.println("Thank You");
						break;
					} else if (charAt == 'Y') {
						continue restart;
					} else {
						System.err.println("The input provided is incorrect...");
						continue;
					}
				} catch (Exception e2) {
					System.err.println("Please Enter Given Character...!!");
					continue;
				}
			}

			boolean flag = false;
			x: while (true) {
				try {
					System.out.print("Would you like to allocate a new game for a new player?   [Y/N] : ");
					char charAt = sc.nextLine().toUpperCase().charAt(0);

					if (charAt == 'N') {
						System.out.println("Thank You...");
						flag = true;
						break;
					} else if (charAt == 'Y') {
						continue restart;
					} else {
						System.err.println("The input provided is incorrect...");
						continue x;
					}
				} catch (Exception e) {
					System.err.println("Please Enter Given Character...!!!");
					continue x;
				}
			}

			if (flag) {
				break;
			}
		}
	}
}