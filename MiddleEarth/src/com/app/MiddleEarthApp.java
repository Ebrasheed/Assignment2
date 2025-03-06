import java.util.Scanner;

public class MiddleEarthApp {
    public static void main(String[] args) {
        MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
        CharacterManager manager = council.getCharacterManager();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add Character\n2. View Characters\n3. Update Character\n4. Delete Character\n5. Execute Attacks\n6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Choose race: 1. Elf 2. Dwarf 3. Human 4. Orc 5. Wizard");
                    int raceChoice = scanner.nextInt();
                    System.out.println("Enter health:");
                    double health = scanner.nextDouble();
                    System.out.println("Enter power:");
                    double power = scanner.nextDouble();
                    scanner.nextLine();
                    
                    MiddleEarthCharacter character = null;
                    switch (raceChoice) {
                        case 1: character = new Elf(name, health, power); break;
                        case 2: character = new Dwarf(name, health, power); break;
                        case 3: character = new Human(name, health, power); break;
                        case 4: character = new Orc(name, health, power); break;
                        case 5: character = new Wizard(name, health, power); break;
                        default: System.out.println("Invalid choice."); continue;
                    }
                    manager.addCharacter(character);
                    System.out.println("Character added successfully!");
                    break;
                
                case 2:
                    manager.displayAllCharacters();
                    break;
                
                case 3:
                    System.out.println("Enter character name to update:");
                    String updateName = scanner.nextLine();
                    System.out.println("Enter new health:");
                    double newHealth = scanner.nextDouble();
                    System.out.println("Enter new power:");
                    double newPower = scanner.nextDouble();
                    scanner.nextLine();
                    
                    if (manager.updateCharacter(updateName, newHealth, newPower)) {
                        System.out.println("Character updated successfully!");
                    } else {
                        System.out.println("Character not found.");
                    }
                    break;
                
                case 4:
                    System.out.println("Enter character name to delete:");
                    String deleteName = scanner.nextLine();
                    if (manager.deleteCharacter(deleteName)) {
                        System.out.println("Character deleted successfully!");
                    } else {
                        System.out.println("Character not found.");
                    }
                    break;
                
                case 5:
                    System.out.println("Enter attacker name:");
                    String attackerName = scanner.nextLine();
                    System.out.println("Enter target name:");
                    String targetName = scanner.nextLine();
                    
                    MiddleEarthCharacter attacker = manager.getCharacter(attackerName);
                    MiddleEarthCharacter target = manager.getCharacter(targetName);
                    
                    if (attacker == null || target == null) {
                        System.out.println("One or both characters not found.");
                    } else {
                        if (attacker.attack(target)) {
                            System.out.println(attacker.getName() + " attacked " + target.getName() + " successfully!");
                        } else {
                            System.out.println(attacker.getName() + "'s attack on " + target.getName() + " failed.");
                        }
                    }
                    break;
                
                case 6:
                    exit = true;
                    break;
                
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
        scanner.close();
    }
}
