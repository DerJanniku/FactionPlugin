
# Project Roadmap

This document outlines the roadmap for developing the Minecraft plugin with faction mechanics, player customization, war systems, and resource management. The project is broken down into phases, starting with essential features and moving toward advanced mechanics and optimizations.

## Phase 1: Core Systems Development

The focus in Phase 1 is on building the foundation of the plugin, including faction creation, player customization, and the basic class system. These features are essential to start testing player interaction.

### 1.1. Player Customization
**Objective:** Create a class and cosmetic selection system for players upon their first login.  
**Key Features:**
- Class selection (Warrior, Mage, Rogue, Archer).
- Cosmetic customization (hats, capes) for visual effects only.
- Persistent player profile storage using YAML/JSON.

**Milestones:**
- Design a GUI for class and cosmetic selection.
- Implement class-specific perks (e.g., potion effects, speed boosts).
- Store player data with unique UUIDs.

### 1.2. Faction Creation & Management
**Objective:** Implement the system for players to choose and join factions.  
**Key Features:**
- Players choose between three factions (Avalon, Thalassia, Norwind).
- Factions have unique traits (e.g., Avalon for magic, Thalassia for water, Norwind for combat).
- Faction leader mechanic based on contribution (rotates weekly).

**Milestones:**
- Create a faction selection GUI.
- Assign faction traits using Minecraft's built-in mechanics (e.g., potion buffs, movement speed).
- Implement leader selection based on points (e.g., kills, resource contribution).

### 1.3. Faction Territory System
**Objective:** Establish the territory system to define faction boundaries and protection rules.  
**Key Features:**
- Territories are protected unless factions declare war.
- Factions can only build with specific materials in their territories.

**Milestones:**
- Use WorldGuard or Factions plugin to define and protect territories.
- Implement material restrictions for faction-specific builds.

## Phase 2: War and Conflict Mechanics

Phase 2 focuses on dynamic faction wars, territory protection toggling, and player conflict.

### 2.1. War Declaration System
**Objective:** Implement a manual voting-based war declaration system.  
**Key Features:**
- Faction leaders initiate war declarations.
- Players vote on whether to declare war.
- Territory protection is toggled off during war periods.

**Milestones:**
- Create a voting system for factions.
- Toggle territory protection based on war status.
- Set war durations (e.g., 24-48 hours).
- Define victory conditions (e.g., kill count, banner capture).

### 2.2. Territory Display System
**Objective:** Display faction territory information in real-time on the HUD.  
**Key Features:**
- Show the current faction's territory in the corner of the screen.
- Update the display as players move between territories.

**Milestones:**
- Develop a HUD using Scoreboard or BossBar API.
- Ensure real-time updates of faction territories.

### 2.3. Revival System
**Objective:** Create a custom respawn system where players must be revived by teammates.  
**Key Features:**
- Players enter a "limbo" state on death.
- Revives require specific items (e.g., golden apples, healing potions).
- Only healer roles or specific players can perform revivals.

**Milestones:**
- Build a custom respawn system to hold players in limbo.
- Create conditions for revival (e.g., items, specific classes).
- Implement a timeout or penalty system for players who aren’t revived.

## Phase 3: Resource & Progression Mechanics

Phase 3 introduces resource-based faction progression, armor upgrades, and incentivized gameplay to encourage long-term engagement.

### 3.1. Resource Contribution System
**Objective:** Allow players to contribute resources to upgrade faction-wide armor and bonuses.  
**Key Features:**
- Factions donate resources to a central "forge" (NPC or chest).
- Once thresholds are met, the entire faction benefits from armor upgrades.

**Milestones:**
- Track player resource contributions using a leaderboard.
- Define resource thresholds for upgrades (e.g., 100 iron for chainmail).
- Distribute armor or bonuses to all faction members upon completion.

### 3.2. Faction Progression & Incentives
**Objective:** Create a system for faction-wide progression and long-term gameplay incentives.  
**Key Features:**
- Factions level up based on performance in wars and resource collection.
- Winning wars grants tangible rewards (e.g., control over key resources, temporary buffs).

**Milestones:**
- Implement a faction leveling system.
- Define rewards for winning wars.
- Create a visible progression system (e.g., faction levels, ranks).

## Recent Changes

- Added Player Customization System classes: Warrior, Mage, Rogue, Archer.
