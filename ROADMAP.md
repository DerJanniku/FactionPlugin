
# Project Roadmap

This document outlines the roadmap for developing the Minecraft plugin with faction mechanics, player customization, war systems, and resource management. The project is broken down into phases, starting with essential features and moving toward advanced mechanics and optimizations.

## Phase 1: Core Systems Development

The focus in Phase 1 is on building the foundation of the plugin, including faction creation, player customization, and the basic class system. These features are essential to start testing player interaction.

### 1.1. Player Customization
**Objective:** Create a class and cosmetic selection system for players upon their first login.  
**Key Features:**
- [x] Class selection (Warrior, Mage, Rogue, Archer).
- [x] Cosmetic customization (hats, capes) for visual effects only.
- [x] Persistent player profile storage using YAML.

**Milestones:**
- [x] Created PlayerProfile class for managing player data.
- [ ] Design a GUI for class and cosmetic selection.
- [x] Implement class-specific perks (e.g., potion effects, speed boosts).
- [x] Store player data with unique UUIDs.

**Completed:**
- Implemented basic class selection system using `/chooseclass` command.
- Created PlayerCustomization class for managing player data.
- Updated main plugin file to handle class selection and player join events.
- Added command to plugin.yml and updated README.md with usage instructions.

**Next Steps:**
- Implement cosmetic customization feature.
- Design and implement GUI for class and cosmetic selection.
- Add class-specific perks and abilities.

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
- Factions can pool resources to unlock upgrades.
- Upgrades include armor enhancements, potion effects, and special abilities.
- Resource contributions are tracked and rewarded.

**Milestones:**
- Design a resource contribution interface.
- Implement upgrade mechanics and effects.
- Track and display faction contributions.

## Phase 4: Advanced Features

### 4.1. Faction Economy System
**Objective:** Introduce an economy system where factions can earn and spend currency.  
**Key Features:**
- Factions earn currency through activities like mining, killing mobs, and completing quests.
- Currency can be spent on faction upgrades, special items, and territory expansions.
- Implement a faction bank where members can deposit and withdraw currency.

### 4.2. Faction Quests and Achievements
**Objective:** Add a quest and achievement system to encourage faction activities.  
**Key Features:**
- Daily, weekly, and monthly quests for factions to complete.
- Achievements for milestones like winning wars, gathering resources, and expanding territory.
- Rewards for completing quests and achievements, such as currency, items, and buffs.

### 4.3. Faction Alliances and Diplomacy
**Objective:** Allow factions to form alliances and manage diplomatic relations.  
**Key Features:**
- Factions can form alliances with other factions for mutual benefits.
- Diplomatic actions like trade agreements, non-aggression pacts, and war declarations.
- A reputation system to track faction relations and influence diplomatic decisions.

### 4.4. Custom Faction Events
**Objective:** Create custom events that factions can participate in for rewards.  
**Key Features:**
- Scheduled events like faction battles, resource hunts, and boss fights.
- Unique rewards for participating and winning events.
- Event-specific mechanics and rules to keep gameplay fresh and exciting.

### 4.5. Advanced Territory Management
**Objective:** Enhance the territory system with more management options.  
**Key Features:**
- Territory upgrades like fortifications, resource generators, and defensive structures.
- Dynamic territory borders that can expand or shrink based on faction activities.
- Territory-specific buffs and debuffs to encourage strategic planning.

### 4.6. Faction Leaderboards and Rankings
**Objective:** Introduce leaderboards and rankings to foster competition.  
**Key Features:**
- Leaderboards for various metrics like wealth, power, territory size, and war victories.
- Seasonal rankings with rewards for top factions.
- Publicly visible stats to encourage competition and bragging rights.

### 4.7. Customizable Faction Ranks
**Objective:** Allow factions to create and manage custom ranks with specific permissions.  
**Key Features:**
- Faction leaders can create custom ranks.
- Assign specific permissions to each rank.
- Promote and demote members within the faction.

### 4.8. Faction Chat and Communication
**Objective:** Implement a dedicated chat system for faction members.  
**Key Features:**
- Private chat channels for faction members.
- Integration with Discord for cross-platform communication.
- Customizable chat prefixes and colors.

### 4.9. Faction Missions and Challenges
**Objective:** Introduce missions and challenges for factions to complete.  
**Key Features:**
- Daily, weekly, and monthly missions.
- Challenges that require cooperation between faction members.
- Rewards for completing missions and challenges.

### 4.10. Faction Base Protection
**Objective:** Enhance base protection mechanisms to prevent griefing.  
**Key Features:**
- Anti-griefing measures for faction bases.
- Customizable protection settings for different areas.
- Alerts and notifications for attempted breaches.

### 4.11. Faction Resource Sharing
**Objective:** Implement a system for sharing resources within the faction.  
**Key Features:**
- Shared resource storage accessible by faction members.
- Permissions for accessing and managing shared resources.
- Tracking and logging of resource contributions and withdrawals.

### 4.12. Faction PvP Arenas
**Objective:** Create dedicated PvP arenas for faction battles.  
**Key Features:**
- Customizable arenas with different themes and layouts.
- Scheduled PvP events and tournaments.
- Leaderboards and rewards for top-performing factions.
