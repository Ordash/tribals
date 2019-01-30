package factory.troops.units;

public class TroopFactory {

    public static Troop troopFactory(TroopType troopType) {
        return troopType.creatingTroop();
    }
}
