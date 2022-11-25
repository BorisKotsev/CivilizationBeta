package gameFiles;

import java.util.List;

public enum Technology 
{
    HORSEBACK_RIDING(5),
    CEREMONIAL_BURIAL(5),
    POTERRY(5),
    ALPHABET(5),
    THE_WEEL(5),
    MASONRY(5),
    BRONZE_WORKING(5),
    
    CHIVALRY(10, HORSEBACK_RIDING),
    MYSTICISM(10, CEREMONIAL_BURIAL),
    CODE_OF_LAWS(12, ALPHABET),
    MAP_MAKING(14, ALPHABET),
    
    WRITING(16, ALPHABET, MASONRY);
    
    private int sciencePoints;

    private List<Technology> neededTechnologies;

    private Technology(int sciencePoints, Technology... technologies)
    {
        this.sciencePoints = sciencePoints;

        this.neededTechnologies = List.of(technologies);
    }

    private Technology(int sciencePoints)
    {
        this(sciencePoints, new Technology[0]);
    }
}
