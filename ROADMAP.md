
# Project Roadmap

This document outlines the roadmap for developing the Minecraft plugin with faction mechanics, player customization, war systems, and resource management. The project is broken down into phases, starting with essential features and moving toward advanced mechanics and optimizations.

## Phase 1: Core Systems Development

### 1.4. Code Review and Refactoring
**Objective:** Ensure all methods are correctly implemented and connected to other classes, and that the code is free of warnings and mistakes.
**Key Features:**
- Reviewed and ensured correct implementation of methods in all relevant classes.
- Fixed compilation errors and ensured all methods are correctly connected.
- Updated references to deprecated or incorrect variables.
- Verified that the code is free of warnings and mistakes.

**Milestones:**
- [x] Reviewed and ensured correct implementation of methods in `Archer.java`, `CosmeticCustomization.java`, `FactionPlugin.java`, `FactionSelectionGUI.java`, `Mage.java`, `PlayerCustomizationGUI.java`, `PlayerProfile.java`, `Rogue.java`, `Warrior.java`, `customization/PlayerCustomization.java`, and `faction/FactionManager.java`.
- [x] Fixed compilation errors related to `PotionEffectType.INCREASE_DAMAGE` and `PotionEffectType.JUMP`.
- [x] Verified that the code is free of warnings and mistakes using Maven.
- [x] Updated references to `PotionEffectType.INCREASE_DAMAGE` and `PotionEffectType.JUMP` to `PotionEffectType.STRENGTH` and `PotionEffectType.JUMP_BOOST` respectively.
- [x] Successfully built the plugin and tested it on a Paper 1.21.1 server.

**Completed:**
- Fixed compilation errors and ensured all methods are correctly implemented and connected to other classes.
- Updated `ROADMAP.md` to document the changes made.

The focus in Phase 1 is on building the foundation of the plugin, including faction creation, player customization, and the basic class system. These features are essential to start testing player interaction.
