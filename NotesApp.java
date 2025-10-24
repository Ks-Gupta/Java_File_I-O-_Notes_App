package Java_File_I.O_Notes_App;
import java.io.*;
import java.util.Scanner;


public class NotesApp {
        private static final String FILE_NAME = "notes.txt";
        public static void main(String[] args){

            Scanner scanner = new Scanner(System.in);
            int choice;

            do{
                System.out.println("=====Welcome to the Notes App!=====");
                System.out.println("1. Add Note");
                System.out.println("2. View Notes");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch(choice) {
                    case 1:
                        addNote(scanner);
                        break;
                    case 2:
                        viewNotes();
                        break;
                    case 3:
                        System.out.println("Exiting the Notes App. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }while(choice != 3);
            scanner.close();

        }

        private static void addNote(Scanner scanner){
            System.out.println("Enter your note: ");
            String note = scanner.nextLine();

            try(FileWriter fw = new FileWriter(FILE_NAME,true)) {
                fw.write(note + "\n");
                System.out.println("Note added successfully!");

            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        }

        //Method to read notes from file
        private static void viewNotes(){
            try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
                String line;
                System.out.println("------------Your Notes------------");
                while((line = br.readLine()) != null){
                    System.out.println("-"+line);
                }
                System.out.println("----------------------------------");
            } catch(FileNotFoundException e){
                System.out.println("No notes found. Start by adding a note!");
            } catch (IOException e) {
                System.out.println("Error reading from file: " + e.getMessage());
            }
        }
}
