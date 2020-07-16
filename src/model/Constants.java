package model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static model.Constants.skillNames.*;
import static model.Constants.statNames.*;

public class Constants {
    public enum Dice {d4, d6, d8, d10, d12, d20}
    public enum statNames {Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma}
    public enum skillNames {Acrobatics, AnimalHandling, Arcana, Athletics, Deception, History, Insight, Intimidation,
        Investigation, Medicine, Nature, Perception, Performance, Persuasion, Religion, SleightOfHand, Stealth, Survival}
    public enum Armor {Light, Medium, Heavy, Shield}
    public enum Weapons {Simple, Martial}
    public enum Tools {AlchemistTools, BrewerSupplies, CalligrapherSupplies, CarpenterTools, CartographerTools,
        CobblerTools, CookUtensils, GlassblowerTools, JewelerTools, LeatherworkerTools, MasonTools, NavigatorTools,
        PainterSupplies, PotterTools, SmithTools, ThievesTools,TinkerTools, WeaverTools, WoodcarverTools};
    public enum StandardLanguages {Common, Dwarvish, Elvish, Giant, Gnomish, Goblin, Halfling, Orc}
    public enum ExoticLanguages {Abyssal, Celestial, Draconic, DeepSpeech, Infernal, Primordial, Sylvan, Undercommon, Druidic}
    public static final Map<skillNames, statNames> skillStats;
    static {
        LinkedHashMap<skillNames, statNames> tempMap = new LinkedHashMap<>();
        tempMap.put(Acrobatics, Strength);
        tempMap.put(AnimalHandling, Wisdom);
        tempMap.put(Arcana, Intelligence);
        tempMap.put(Athletics, Strength);
        tempMap.put(Deception, Charisma);
        tempMap.put(History, Intelligence);
        tempMap.put(Insight, Wisdom);
        tempMap.put(Intimidation, Intelligence);
        tempMap.put(Investigation, Intelligence);
        tempMap.put(Medicine, Wisdom);
        tempMap.put(Nature, Intelligence);
        tempMap.put(Perception, Wisdom);
        tempMap.put(Performance, Charisma);
        tempMap.put(Persuasion, Charisma);
        tempMap.put(Religion, Intelligence);
        tempMap.put(SleightOfHand, Dexterity);
        tempMap.put(Stealth, Dexterity);
        tempMap.put(Survival, Wisdom);
        skillStats = Collections.unmodifiableMap(tempMap);
    }


}