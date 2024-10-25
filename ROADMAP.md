
# Project Roadmap

This document outlines the roadmap for developing the Minecraft plugin with faction mechanics, player customization, war systems, and resource management. The project is broken down into phases, starting with essential features and moving toward advanced mechanics and optimizations.

## Phase 1: Core Systems Development

### 1. Player Customization System

#### 1.1. Classes
- **Warrior:** High health, access to melee buffs like strength potions.
- **Mage:** Ability to use magic items (enchanted books, firework rockets for ranged attacks).
- **Rogue:** Faster movement, better stealth, and sneak attack bonuses.
- **Archer:** Bonuses to ranged weapons like bows and crossbows.

#### 1.2. Cosmetics
- Purely visual (hats, capes, particle effects) and accessible through achievements or server currency.
- No gameplay effects to maintain balance.

#### 1.3. Profile Storage
- Player class and cosmetic choices stored in a YAML or JSON file associated with each player’s UUID.

### 2. Faction System

#### 2.1. Faction Traits
- **Avalon (Magic-oriented):** Specializes in potion crafting and enchantments.
- **Thalassia (Water-based):** Benefits from faster movement in water and can breathe longer underwater.
- **Norwind (Combat-based):** Better melee damage and enhanced durability on armor.

#### 2.2. Faction Leader Mechanic
- Leadership determined by contribution metrics, not just kills.
- Leadership rotates weekly or monthly.

### 3. Faction Building Rules & War System

#### 3.1. War Declaration
- Manual voting-based war declaration system.
- Wars last a set time period (e.g., 24 or 48 hours).

#### 3.2. War Mechanics
- Territories become unprotected during war.
- Wars end when either faction achieves a set objective.

#### 3.3. Building Materials
- Faction-specific materials for certain strategic builds.

### 4. Territory Display System

#### 4.1. HUD Display
- Displays the current faction territory in the corner using a plugin like Scoreboard or BossBar.

#### 4.2. Real-Time Updates
- Territory updates instantly as players cross boundaries.

### 5. Revival System

#### 5.1. Who Can Revive?
- Only specific players (e.g., a “Healer” class) can revive others.

#### 5.2. Revival Conditions
- Reviving a player costs a resource, such as XP levels or valuable items.

#### 5.3. Timeouts or Penalties
- If a player isn’t revived within a set time, they respawn at their faction’s base with minor penalties.

### 6. Resource Contribution & Armor Upgrades

#### 6.1. Resource Thresholds
- Set resource goals for each faction that progressively unlock upgrades.

#### 6.2. Armor & Other Upgrades
- Faction-wide upgrades include faster resource gathering, stronger fortifications, or buffs to health regeneration.

#### 6.3. Tracking Contributions
- Use a leaderboard to track contributions.

### 7. Scalability & Optimization

#### 7.1. Server Size
- System works for both small (20-50 players) and large (100+ players) servers.

#### 7.2. Simplified Version for Small Servers
- Remove certain mechanics or focus on PvP events rather than full-scale territory battles.

### 8. Additional Mechanics & Future Expansions

#### 8.1. Faction Progression
- Factions progress over time based on performance in wars and resource collection.

#### 8.2. Incentives for War
- Winning wars grants tangible rewards, such as control over key resources.

#### 8.3. Expansion Planning
- Future expansions could introduce new factions, events, or roles.

## Next Steps

- **Faction management and class systems** (class selection, faction traits).
- **War and building mechanics** (territory protection toggling, war declarations).
- **Basic revival and contribution systems** (healer role, resource donation and tracking).

This ensures that we have a functional base to build on, allowing us to test performance and balance before expanding into more complex mechanics.
