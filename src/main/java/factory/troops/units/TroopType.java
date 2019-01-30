package factory.troops.units;

public enum TroopType {
    WARRIOR {
        public Troop creatingTroop() {
            return new TroopWarrior();
        }
    },
    GUARD {
        public Troop creatingTroop() {
            return new TroopGuard();
        }
    };

    public Troop creatingTroop(){
        return null;
    }
}
