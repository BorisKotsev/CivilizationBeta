package gameFiles;

import java.util.Optional;

public class SelectionManager 
{
    public static MoveableUnit nextUnit(Player player)
    {
        Optional<MoveableUnit> unit = player.getUnits().stream().
                                    filter(u -> !u.isMoved() && !u .isFreezed()).findFirst();        
        
        if(unit.isPresent())
        {
            return unit.get();
        }
        
        return null;
    }    
}
