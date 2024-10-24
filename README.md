
# FactionPlugin

FactionPlugin is a Minecraft plugin that introduces faction mechanics, player customization, war systems, and resource management. Players can create or join factions, engage in wars, and contribute resources to upgrade their faction's capabilities.

## Features

- **Player Customization:** Choose from multiple classes (Warrior, Mage, Rogue, Archer) with unique abilities and cosmetic options.
- **Faction System:** Join one of three factions (Avalon, Thalassia, Norwind) with distinct traits and benefits.
- **War Mechanics:** Declare wars between factions with dynamic territory protection and victory conditions.
- **Resource Management:** Contribute resources to upgrade faction-wide armor and bonuses.

## Player Customization System

### Classes

- **Warrior:** High health, access to melee buffs like strength potions.
- **Mage:** Ability to use magic items (enchanted books, firework rockets for ranged attacks).
- **Rogue:** Faster movement, better stealth, and sneak attack bonuses.
- **Archer:** Bonuses to ranged weapons like bows and crossbows.

## Installation

1. **Download the Plugin:**
   - Clone this repository or download the JAR file from the releases section.

2. **Set Up a Minecraft Server:**
   - Use a Spigot or Paper server for optimal performance.

3. **Install the Plugin:**
   - Place the downloaded JAR file into the `plugins` folder of your Minecraft server.

4. **Start the Server:**
   - Launch your server and the plugin will be enabled automatically.

## Configuration

- The plugin configuration can be found in the `plugins/FactionPlugin` directory after the first run. Adjust settings as needed.

## Usage

### Material Restrictions
- Each faction can build with specific materials:
  - **Avalon**: Diamond Block, Emerald Block
  - **Thalassia**: Water Bucket, Prismarine
  - **Norwind**: Iron Block, Anvil

### Faction Selection
- Players can open the faction selection GUI using the `/selectfaction` command.
- Use the GUI to select your faction (Avalon, Thalassia, Norwind).

### Class and Cosmetic Selection
When players first join the server, they will be prompted to choose a class.
Players can choose their class using the `/chooseclass` command.
Players can open the class and cosmetic selection GUI using the `/customize` command.
Use the GUI to select your class and cosmetics (hats, capes, golden hats, diamond capes).

### Class-Specific Perks and Abilities
- **Warrior:** Can boost health and damage.
- **Mage:** Can boost mana and cast spells.
- **Rogue:** Can boost speed and enable invisibility.
- **Archer:** Can boost accuracy and enable rapid fire.

### Faction Traits and Leader Selection
- **Avalon:** Magic trait with increased damage.
- **Thalassia:** Water trait with water breathing.
- **Norwind:** Combat trait with increased speed.
- Faction leaders are selected based on points.

- When players first join the server, they will be prompted to choose a class.
- Players can choose their class using the `/chooseclass` command.
- Engage in wars and manage resources through faction interactions.

## Commands

- `/chooseclass <classname>`: Choose your player class. Available classes are warrior, mage, rogue, and archer.
- `/joinfaction <factionname>`: Join a faction. Available factions are Avalon, Thalassia, and Norwind.
- `/leavefaction`: Leave your current faction.
- `/factioninfo`: Get information about your current faction.

## Getting Started

1. Join the server for the first time.
2. You will be prompted to choose a class.
3. Use the command `/chooseclass <classname>` to select your desired class.
4. Join a faction using `/joinfaction <factionname>`.
5. Use `/factioninfo` to see details about your faction.
6. Interact with other players and contribute to your faction's growth.
7. If you want to change factions, use `/leavefaction` before joining a new one.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
